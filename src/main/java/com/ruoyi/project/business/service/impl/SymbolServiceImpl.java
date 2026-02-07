package com.ruoyi.project.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.mapper.SymbolMapper;
import com.ruoyi.project.business.domain.Symbol;
import com.ruoyi.project.business.service.ISymbolService;

/**
 * 代币表Service业务层处理
 *
 * @author gpthk
 * @date 2025-03-22
 */
@Service
public class SymbolServiceImpl implements ISymbolService {
    @Autowired
    private SymbolMapper symbolMapper;

    /**
     * 查询代币表
     *
     * @param id 代币表主键
     * @return 代币表
     */
    @Override
    public Symbol selectSymbolById(Long id)
    {
        return symbolMapper.selectSymbolById(id);
    }

    /**
     * 查询代币表列表
     *
     * @param symbol 代币表
     * @return 代币表
     */
    @Override
    public List<Symbol> selectSymbolList(Symbol symbol)
    {
        return symbolMapper.selectSymbolList(symbol);
    }

    /**
     * 新增代币表
     *
     * @param symbol 代币表
     * @return 结果
     */
    @Override
    public int insertSymbol(Symbol symbol) {
        return symbolMapper.insertSymbol(symbol);
    }

    /**
     * 修改代币表
     *
     * @param symbol 代币表
     * @return 结果
     */
    @Override
    public int updateSymbol(Symbol symbol) {
        return symbolMapper.updateSymbol(symbol);
    }

    /**
     * 批量删除代币表
     *
     * @param ids 需要删除的代币表主键
     * @return 结果
     */
    @Override
    public int deleteSymbolByIds(Long[] ids)
    {
        return symbolMapper.deleteSymbolByIds(ids);
    }

    /**
     * 删除代币表信息
     *
     * @param id 代币表主键
     * @return 结果
     */
    @Override
    public int deleteSymbolById(Long id)
    {
        return symbolMapper.deleteSymbolById(id);
    }
}
