package com.common.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bandit
 * @createTime 2022/6/6 17:06
 */
public class ResultVO extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ResultVO() {
    }

    public static ResultVO success() {
        ResultVO r = new ResultVO();
        r.put("code", 200);
        r.put("msg", "success");
        return r;
    }

    public static ResultVO success(String msg) {
        ResultVO r = new ResultVO();
        r.put("msg", msg);
        return r;
    }

    public static ResultVO success(Map<String, Object> map) {
        ResultVO r = new ResultVO();
        r.putAll(map);
        return r;
    }

    public ResultVO put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static ResultVO error() {
        ResultVO r = new ResultVO();
        r.put("code", 500);
        r.put("msg", "未知错误");
        return r;
    }

    public static ResultVO error(String msg) {
        ResultVO r = new ResultVO();
        r.put("code", 500);
        r.put("msg", msg);
        return r;
    }

    public static ResultVO error(Map<String, Object> map) {
        ResultVO r = new ResultVO();
        r.putAll(map);
        return r;
    }

}
