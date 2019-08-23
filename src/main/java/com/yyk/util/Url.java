package com.yyk.util;

public interface Url {
    /*============通用url开始===========*/
    /*列表数据查询所有*/
    String SHOW="/show";
    String SELECT_LIST_ALL = "/selectListAll";
    /*列表数据查询子数据*/
    String SELECT_LIST_CHILD = "/selectListChild";
    /*列表数据查询父数据*/
    String SELECT_FATHERLIST_BY_PAGE = "/selectFatherListByPage";
    /*列表数据分页查询*/
    String SELECT_LIST_BY_PAGE = "/selectListByPage";
    /*信息查询*/
    String SELECT_INFO = "/selectInfo";
    /*插入数据*/
    String INSERT_INFO = "/insertInfo";
    /*更新数据*/
    String UPDATE_INFO = "/updateInfo";
    /*更新状态*/
    String UPDATE_STATUS = "/updateStatus";
    /* 删除数据 */
    String REMOVE_INFO_BY_ID = "/removeById";


    /*文件管理*/
    String FILE_MANAGE="fileManage";
    String FILE_UPLOAD="fileUpload";

    /*Redis管理*/
    String REDIS_MANAGE="redisManage";
    String REDIS_SELECT="redisSelect";

    /*流管理*/
    String STREAM_MANAGE="streamManage";
    String STREAM_FILTER="streamFilter";
    String STREAM_FOREACH="streamForeach";
}
