package com.ruoyi.project.business.service;

import java.util.List;
import com.ruoyi.project.business.domain.Symbol;

/**
 * 代币表Service接口
 *
 * @author gpthk
 * @date 2025-03-22
 */
public interface ISymbolService {
    /**
     * 查询代币表
     *
     * @param id 代币表主键
     * @return 代币表
     */
    Symbol selectSymbolById(Long id);

    /**
     * 查询代币表列表
     *
     * @param symbol 代币表
     * @return 代币表集合
     */
    List<Symbol> selectSymbolList(Symbol symbol);

    /**
     * 新增代币表
     *
     * @param symbol 代币表
     * @return 结果
     */
     int insertSymbol(Symbol symbol);

    /**
     * 修改代币表
     *
     * @param symbol 代币表
     * @return 结果
     */
     int updateSymbol(Symbol symbol);

    /**
     * 批量删除代币表
     *
     * @param ids 需要删除的代币表主键集合
     * @return 结果
     */
     int deleteSymbolByIds(Long[] ids);

    /**
     * 删除代币表信息
     *
     * @param id 代币表主键
     * @return 结果
     */
     int deleteSymbolById(Long id);
}
