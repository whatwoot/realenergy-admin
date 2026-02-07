package com.ruoyi.project.handler;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author quzhimin
 * @date 2024/4/16 15:27
 */
@Slf4j
public class LongTimeHandler implements ExcelHandlerAdapter {
    @Override
    public Object format(Object value, String[] args, Cell cell, Workbook wb) {
        if (value == null) {
            return null;
        }
        Long time = (Long) value;
        if(time.toString().length() == 10){
            time *= 1000;
        }
        String format = null;
        if (args.length > 0) {
            format = args[0];
        }
        return DateUtils.timestamp4Export(time, format);
    }
}
