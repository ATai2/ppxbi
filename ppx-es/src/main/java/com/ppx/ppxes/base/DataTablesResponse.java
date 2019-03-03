package com.ppx.ppxes.base;

/**
 * DataTables（前端框架）相应结构
 *
 * Created by gegf
 */
public class DataTablesResponse extends ResponseEntity {

    //验证结果
    private int draw;
    //总数
    private long recordsTotal;
    //分页
    private long recordsFiltered;

    public DataTablesResponse(Integer code) {
        super(code);
    }

    public DataTablesResponse(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}

