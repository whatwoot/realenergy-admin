package com.ruoyi;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.project.business.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 *
 * @author feiwo 2025-09-16
 */
@SpringBootTest
public class SqlStructDiffPojoJavaTest {

    private static final String[] ignoreFields = new String[]{"createTime", "updateTime", "createBy", "updateBy", "remark", "params", "searchValue"};
    private static final String[] ignorePojoFields = new String[]{"serialVersionUID"};

    @Resource
    private DataSource dataSource;

    @Test
    public void compareTableWithPojo() throws Exception {
        diff("a_asset", Asset.class);
        System.out.println("=========================================================");
        diff("a_asset_flow", AssetFlow.class);
        System.out.println("=========================================================");
        diff("a_withdraw_flow", WithdrawFlow.class);
        System.out.println("=========================================================");
        diff("u_login", Login.class);
        System.out.println("=========================================================");
        diff("u_member", Member.class);
        System.out.println("=========================================================");
//        diff("c_chain_address", ChainAddress.class);
//        System.out.println("=========================================================");
//        diff("c_chain_work", ChainWork.class);
//        System.out.println("=========================================================");
        diff("u_member_wallet", MemberWallet.class);
        System.out.println("=========================================================");
        diff("u_team_level", TeamLevel.class);
        System.out.println("=========================================================");
        diff("u_invite_level", InviteLevel.class);
        System.out.println("=========================================================");
    }

    private void diff(String tableName, Class<?> clazz) throws SQLException {
        // 1. 获取数据库字段
        Set<String> dbFields = new HashSet<>();
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getColumns(conn.getCatalog(), null, tableName, null);
            while (rs.next()) {
                String columnName = StrUtil.toCamelCase(rs.getString("COLUMN_NAME")); // 下划线命名
                boolean b = Arrays.asList(ignoreFields).contains(columnName);
                if (!b) {
                    dbFields.add(columnName);
                }
            }
        }

        // 2. 获取 POJO 字段
        Set<String> pojoFields = Arrays.stream(clazz.getDeclaredFields())
                .map(Field::getName)
                .filter(name -> !Arrays.asList(ignorePojoFields).contains(name))
                .collect(Collectors.toSet());

        // 3. 比对
        Set<String> notInPojo = new HashSet<>(dbFields);
        notInPojo.removeAll(pojoFields);

        Set<String> notInDb = new HashSet<>(pojoFields);
        notInDb.removeAll(dbFields);

        System.out.println(StrUtil.format("表名：{} -- 类名：{} ---> 数据库有但POJO没有的字段: {}", tableName, clazz.getSimpleName(), notInPojo));
        System.out.println(StrUtil.format("表名：{} -- 类名：{} ---> POJO有但数据库没有的字段: {}", tableName, clazz.getSimpleName(), notInDb));
    }
}
