package com.ruoyi.common.utils;

import com.cs.sp.common.CommonException;
import com.cs.sp.common.HttpStatus;
import com.cs.sp.common.exception.BaseException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author quzhimin
 * @date 2024/4/25 18:18
 */
public abstract class Assets {
    /**
     * 用于参数验证的场景
     *
     * @param expression
     * @param code
     * @param args
     */
    public static void isTrue(boolean expression, String code, Object... args) {
        if (!expression) {
            throwException(code, args);
        }
    }

    /**
     * 用于参数验证的场景
     *
     * @param obj
     * @param code
     * @param args
     */
    public static void isNotBlank(String obj, String code, Object... args) {
        isTrue(StringUtils.hasText(obj), code, args);
    }

    /**
     * 用于参数验证的场景
     *
     * @param obj
     * @param code
     * @param args
     */
    public static void isBlank(String obj, String code, Object... args) {
        isTrue(!StringUtils.hasText(obj), code, args);
    }

    /**
     * 用于参数验证的场景
     *
     * @param obj
     * @param code
     * @param args
     */
    public static void notNull(Object obj, String code, Object... args) {
        isTrue(obj != null, code, args);
    }


    /**
     * 用于业务是否匹配的判断
     *
     * @param obj
     * @param code
     * @param args
     */
    public static void expectNull(Object obj, String code, Object... args) {
        if (obj != null) {
            throwException(code, args);
        }
    }

    /**
     * 用于业务是否匹配的判断
     *
     * @param obj
     * @param code
     * @param args
     */
    public static void expectNotNull(Object obj, String code, Object... args) {
        if (obj == null) {
            throwException(code, args);
        }
    }

    /**
     * 用于业务是否匹配的判断
     *
     * @param result
     * @param code
     * @param args
     */
    public static void expectGt0(int result, String code, Object... args) {
        if (result < 1) {
            throwException(code, args);
        }
    }

    public static void expectGte0(int result, String code, Object... args) {
        if (result < 0) {
            throwException(code, args);
        }
    }

    public static void expectLte0(int result, String code, Object... args) {
        if (result > 0) {
            throwException(code, args);
        }
    }

    public static void expectLt0(int result, String code, Object... args) {
        if (result > -1) {
            throwException(code, args);
        }
    }

    /**
     * 用于业务是否匹配的判断
     *
     * @param result
     * @param code
     * @param args
     */
    public static void expectNotGt0(int result, String code, Object... args) {
        if (result > 0) {
            throwException(code, args);
        }
    }

    /**
     * 用于业务是否匹配的判断
     *
     * @param expression
     * @param code
     * @param args
     */
    public static void expect(boolean expression, String code, Object... args) {
        if (!expression) {
            throwException(code, args);
        }
    }


    public static void expectEmpty(Map<?, ?> map, String code, Object... args) {
        if (!CollectionUtils.isEmpty(map)) {
            throwException(code, args);
        }
    }

    public static void expectEmpty(Collection<?> collection, String code, Object... args) {
        if (CollectionUtils.isEmpty(collection)) {
            throwException(code, args);
        }
    }

    public static void expectNotEmpty(Collection<?> collection, String code, Object... args) {
        if (CollectionUtils.isEmpty(collection)) {
            throwException(code, args);
        }
    }

    public static void expectNotEmpty(Map<?, ?> map, String code, Object... args) {
        if (CollectionUtils.isEmpty(map)) {
            throwException(code, args);
        }
    }


    public static void needLogin(boolean expression){
        if(!expression){
            throwException(HttpStatus.UNAUTHORIZED, "auth.notLogin");
        }
    }
    /**
     * 401 未登录或登录过期
     * @param expression
     * @param code
     * @param args
     */
    public static void needLogin(boolean expression, String code, Object... args){
        if(!expression){
            throwException(HttpStatus.UNAUTHORIZED, code, args);
        }
    }

    public static void hasPermission(boolean expression) {
        if (!expression) {
            throwException(HttpStatus.FORBIDDEN, "sp.common.403");
        }
    }

    /**
     * 403，已登录，但是仍然没有权限
     * 用于越权检查，资源归属
     *
     * @param expression
     */
    public static void hasPermission(boolean expression, String code, Object... args) {
        if (!expression) {
            throwException(HttpStatus.FORBIDDEN, code, args);
        }
    }

    public static void error(boolean expression, String code, Object... args) {
        error(expression, HttpStatus.PRECONDITION_FAILED, code, args);
    }

    /**
     * 用于其他系统错误
     * 因为
     * 需要传入具体错误码和错误信息
     *
     * @param expression
     * @param statusCode
     * @param code
     * @param args
     */
    public static void error(boolean expression, HttpStatus statusCode, String code, Object... args) {
        if (!expression) {
            throwException(statusCode.value(), code, args);
        }
    }

    public static void throwException(String code, Object... args) {
        throw new CommonException(500, code, args);
    }

    public static void throwException(HttpStatus statusCode, String code, Object... args) {
        throwException(statusCode.value(), code, args);
    }

    public static void throwException(int statusCode, String code, Object... args) {
        throw new CommonException(statusCode, code, args);
    }
}
