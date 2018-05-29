package com.common.mvc.x.network;

/**
 * 请求类型.
 *
 * @author yLw 16_04_26
 */
public class FuctionType {

    //TODO 注册, 登录相关fuction.

    /**
     * 注册.
     */
    public static final String REGIST = "regist";

    /**
     * 获取验证码
     */
    public static final String GET_VERIFICATION_CODE = "get_verification_code";

    /**
     * 提交反馈信息
     */
    public static final String SUBMIT_FEEDBACK = "submit_feedback";

    /**
     * 从服务器查询摄像头的绑定信息
     */
    public static final String QUERY_CAMERA_BIND = "query_camera_bind";
    public static final String INSERT_CAMERA_BIND = "insert_camera_bind";
    public static final String DELETE_CAMERA_BIND = "delete_camera_bind";

    /**
     * 登录.
     */
    public static final String LOGIN = "login";

    /**
     * 查询机器人
     */
    public static final String QUERY_ROBDEVICE_STATUS = "query_robdevice_status";
    public static final String QUERY_ROBDEVICE_STATUS_BY_SERVER = "query_robdevice_status_by_server";
    /**
     * 不明白是**什么鬼...
     */
    public static final String LOGIN_RESPONSE = "loginrsp";

    /**
     * 通过服务器登录主机.
     */
    public static final String LOGIN_GATEWAY_BY_SERVER = "login_gateway_by_server";

    /**
     * 直接登录主机.
     */
    public static final String LOGIN_GATEWAY = "login_gateway";

    /**
     * 主机登录.
     */
    public static final String GATEWAY_LOGIN = "gateway_login_server";

    //TODO password fuction.

    /**
     * 修改密码.
     */
    public static final String MODIFY_PASSWORD = "change_password";

    /**
     * 重置密码.
     */
    public static final String RESET_PASSWORD = "reset_password";

    /**
     * 找回密码.
     */
    public static final String FIND_PASSWORD = "get_back_password";

    /**
     * 修改用户信息.
     */
    public static final String MODIFY_INFO = "change_info";

    /**
     * 心跳.
     */
    public static final String HEARTBEAT = "beacon_app";

    /**
     * 绑定主机.
     */
    public static final String BIND_GATEWAY = "bind_gateway";

    /**
     * 解除主机绑定.
     */
    public static final String UNBIND_GATEWAY_BY_SERVER = "unbind_gateway_by_server";


    /**
     * 绑定主机.
     */
    public static final String BIND_GATEWAY_BY_SERVER = "bind_gateway_by_server";

    /**
     * 解除主机绑定.
     */
    public static final String UNBIND_GATEWAY = "unbind_gateway";

    //TODO device fuction.

    /**
     * 添加设备.
     */
    public static final String ADD_DEVICE = "insert_node";

    /**
     * 添加设备通过服务器.
     */
    public static final String ADD_DEVICE_BY_SERVER = "insert_node_by_server";

    /**
     * 删除主机.
     */
    public static final String DELETE_DEVICE = "delete_device";
    /**
     * 删除主机设备通过服务器
     */
    public static final String DELETE_DEVICE_BY_SERVER = "delete_device_by_server";
    /**
     * 隐藏/显示设备.
     */
    public static final String HIDE_DEVICE = "hide_device";

    /**
     * 修改设备.
     */
    public static final String UPDATE = "update_device";

    /**
     * 通过服务器修改设备.
     */
    public static final String UPDATE_DEVICE_BY_SERVER = "update_device_by_server";

    /**
     * 设置临时密码
     */
    public static final String SET_DEVICE_PASSWORD_BY_SERVER = "set_device_password_by_server";
    public static final String SET_DEVICE_PASSWORD = "set_device_password";

    /**
     * 操作设备.
     */
    public static final String OPERATE_DEVICE = "operate_device";

    /**
     * 通过服务器操作设备.
     */
    public static final String OPERATE_DEVICE_BY_SERVER = "operate_device_by_server";

    //TODO room fuction.

    /**
     * 添加房间.
     */
    public static final String ADD_ROOM = "insert_room";

    /**
     * 通过服务器添加房间.
     */
    public static final String ADD_ROOM_BY_SERVER = "insert_room_by_server";

    /**
     * 删除房间.
     */
    public static final String DELETE_ROOM = "delete_room";

    /**
     * 通过服务器删除房间.
     */
    public static final String DELETE_ROOM_BY_SERVER = "delete_room_by_server";

    /**
     * 修改房间.
     */
    public static final String UPDATE_ROOM = "update_room";

    /**
     * 通过服务器修改房间.
     */
    public static final String UPDATE_ROOM_BY_SERVER = "update_room_by_server";

    /**
     * 向房间添加设备.
     */
    public static final String ADD_DEVICE_INTO_ROOM = "insert_device_into_room";

    /**
     * 通过服务器向房间添加设备.
     */
    public static final String ADD_DEVICE_INTO_ROOM_BY_SERVER = "insert_device_into_room_by_server";

    /**
     * 从房间删除设备.
     */
    public static final String DELETE_DEVICE_FROM_ROOM = "delete_device_from_room";

    /**
     * 通过服务器从房间删除设备.
     */
    public static final String DELETE_DEVICE_FROM_ROOM_BY_SERVER = "delete_device_from_room_by_server";

    /**
     * 创建场景.
     */
    public static final String ADD_SCENE = "insert_scene";

    /**
     * 通过服务器创建场景.
     */
    public static final String ADD_SCENE_BY_SERVER = "insert_scene_by_server";

    /**
     * 删除场景.
     */
    public static final String DELETE_SCENE = "delete_scene";

    /**
     * 通过服务器删除场景.
     */
    public static final String DELETE_SCENE_BY_SERVER = "delete_scene_by_server";

    /**
     * 修改场景.
     */
    public static final String MODIFY_SCENE = "update_scene";

    /**
     * 通过服务器修改场景.
     */
    public static final String MODIFY_SCENE_BY_SERVER = "update_scene_by_server";

    /**
     * 执行场景.
     */
    public static final String OPERATE_SCENE = "operate_scene";

    /**
     * 通过服务器执行场景.
     */
    public static final String OPERATE_SCENE_BY_SERVER = "operate_scene_by_server";

    //TODO linkage fuction.

    /**
     * 创建联动.
     */
    public static final String ADD_LINKAGE = "insert_linkage";

    /**
     * 通过服务器创建联动.
     */
    public static final String ADD_LINKAGE_BY_SERVER = "insert_linkage_by_server";

    /**
     * 删除联动.
     */
    public static final String DELETE_LINKAGE = "delete_linkage";

    /**
     * 通过服务器删除关联.
     */
    public static final String DELETE_LINKAGE_BY_SERVER = "delete_linkage_by_server";

    /**
     * 修改联动.
     */
    public static final String MODIFY_LINKAGE = "update_linkage";

    /**
     * 通过服务器修改联动.
     */
    public static final String MODIFY_LINKAGE_BY_SERVER = "update_linkage_by_server";

    //TODO 报警相关fuction.

    /**
     * 报警事件.
     */
    public static final String ALARM_EVENT = "alarm_event";

    /**
     * 局域网查询query_alarm_record/
     */
    public static final String QUERY_ALARM_RECORD = "query_alarm_record";

    /**
     * 通过服务器查询query_alarm_record _by_server/
     */
    public static final String QUERY_ALARM_RECORD_BY_SERVER = "query_alarm_record_by_server";

    /**
     * 从服务器查询query_alarm_record_from_server查询报警记录
     */

    public static final String QUERY_ALARM_RECORD_FROM_SERVER = "query_alarm_record_from_server";
    /**
     * 创建报警.
     */
    public static final String ALARM_INSERT = "insert_alarm";
    public static final String ALARM_INSERT_BY_SERVER = "insert_alarm_by_server";

    /**
     * 修改报警.
     */
    public static final String ALARM_UPDATE = "update_alarm";
    public static final String ALARM_UPDATE_BY_SERVER = "update_alarm_by_server";


    /**
     * 一键布防 撤防
     */
    public static final String ALL_ALARM_UPDATE = "update_all_alarm";
    public static final String ALL_ALARM_UPDATE_BY_SERVER = "update_all_alarm_by_server";

    /**
     * 删除报警.
     */
    public static final String ALARM_DELETE = "delete_alarm";
    public static final String ALARM_DELETE_BY_SERVER = "delete_alarm_by_server";

    //TODO sync to server fuction.

    /**
     * 设备列表同步到服务器.
     */
    public static final String SYNC_DEVICE_LIST_TO_SERVER = "sync_device_list_to_app";

    /**
     * 设备信息同步到服务器.
     */
    public static final String SYNC_DEVICE_INFO_TO_SERVER = "sync_device_info_to_server";

    /**
     * 设备状态同步到服务器.
     */
    public static final String SYNC_DEVICE_STATE_TO_SERVER = "sync_device_status_to_server";

    /**
     * 房间信息同步到服务器.
     */
    public static final String SYNC_ROOM_INFO_TO_SERVER = "sync_room_info_to_server";

    /**
     * 场景信息同步到服务器.
     */
    public static final String SYNC_SCENE_INFO_TO_SERVER = "sync_scene_info_to_server";

    /**
     * 联动信息同步到服务器.
     */
    public static final String SYNC_LINKAGE_INFO_TO_SERVER = "sync_linkage_info_to_server";

    //TODO sync to gateway fuction.

    /**
     * 设备信息同步到主机.
     */
    public static final String SYNC_DEVICE_INFO_TO_GATEWAY = "sync_device_info_to_gateway";

    /**
     * 设备状态同步到主机.
     */
    public static final String SYNC_DEVICE_STATE_TO_GATEWAY = "sync_device_status_to_gateway";

    /**
     * 同步房间信息到主机.
     */
    public static final String SYNC_ROOM_INFO_TO_GATEWAY = "sync_room_info_to_gateway";

    /**
     * 同步场景信息到主机.
     */
    public static final String SYNC_SCENE_INFO_TO_GATEWAY = "sync_scene_info_to_gateway";

    /**
     * 同步联动信息到主机.
     */
    public static final String SYNC_LINKAGE_INFO_TO_GATEWAY = "sync_linkage_info_to_gateway";

    /**
     * 同步绑定用户信息.
     */
    public static final String SYNC_BIND_USER = "sync_bind_user_info_to_gateway";

    /**
     * n个报警设置信息同步到主机.
     */
    public static final String SYNC_ALARM_INFO = "sync_alarm_info_to_gateway";

    //TODO sync to app from gateway.

    /**
     * 同步设备信息到手机.
     */
    public static final String SYNC_DEVICE_INFO_TO_APP = "sync_device_info_to_app";

    /**
     * 同步设备状态到手机.
     */
    public static final String SYNC_DEVICE_STATE_TO_APP = "sync_device_status_to_app";

    /**
     * 同步房间信息到手机.
     */
    public static final String SYNC_ROOM_INFO_TO_APP = "sync_room_info_to_app";

    /**
     * 同步场景信息到手机.
     */
    public static final String SYNC_SCENE_INFO_TO_APP = "sync_scene_info_to_app";

    /**
     * 同步联动信息到手机.
     */
    public static final String SYNC_LINKAGE_INFO_TO_APP = "sync_linkage_info_to_app";

    //TODO sync to app from server.

    /**
     * 从服务器同步设备信息到手机.
     */
    public static final String SYNC_DEVICE_INFO_FROM_SERVER = "sync_device_info_to_app_by_server";

    /**
     * 从服务器同步设备状态到手机.
     */
    public static final String SYNC_DEVICE_STATE_FROM_SERVER = "sync_device_status_to_app_by_server";

    /**
     * 从服务器同步房间信息到手机.
     */
    public static final String SYNC_ROOM_INFO_FROM_SERVER = "sync_room_info_to_app_by_server";

    /**
     * 从服务器同步场景信息到手机.
     */
    public static final String SYNC_SCENE_INFO_FROM_SERVER = "sync_scene_info_to_app_by_server";

    /**
     * 从服务器同步联动信息到手机.
     */
    public static final String SYNC_LINKAGE_INFO_FROM_SERVER = "sync_linkage_info_to_app_by_server";

    /**
     * n个报警设置信息从服务器同步到手机.
     */
    public static final String SYNC_ALARM_INFO_FROM_SERVER = "sync_alarm_info_to_app_by_server";

    /**
     * 报警信息.
     */
    public static final String ALARM_INFO = "alarm_info";

    //TODO query from gateway.

    /**
     * 从主机查询设备状态.
     */
    public static final String QUERY_DEVICE_STATE_FROM_GATEWAY = "query_device_status";

    /**
     * 从主机查询设备信息.
     */
    public static final String QUERY_DEVICE_INFO_FROM_GATEWAY = "query_device_info";

    /**
     * 从主机查询设备数据记录.
     */
    public static final String QUERY_DEVICE_DATA_FROM_GATEWAY = "query_device_data_record";

    /**
     * 从主机查询设备操作记录.
     */
    public static final String QUERY_DEVICE_OPERATE_RECORD_FROM_GATEWAY = "query_device_operate_record";

    /**
     * 从主机查询场景信息.
     */
    public static final String QUERY_SCENE_INFO_FROM_GATEWAY = "query_scene_info";

    /**
     * 从主机查询联动信息.
     */
    public static final String QUERY_LINKAGE_INFO_FROM_GATEWAY = "query_linkage_info";

    /**
     * 从主机查询房间信息.
     */
    public static final String QUERY_ROOM_INFO_FROM_GATEWAY = "query_room_info";

    /**
     * 查询主机配置信息.
     */
    public static final String QUERY_GATEWAY_CONFIG = "query_gateway_config";

    /**
     * 查询主机信息通过服务器.
     */
    public static final String QUERY_GATEWAY_INFO_BY_SERVER = "query_gateway_info_by_server";
    /**
     * 查询主机信息.
     */
    public static final String QUERY_GATEWAY_INFO = "query_gateway_info";

    /**
     * 查询主机配置信息通过服务器.
     */
    public static final String QUERY_GATEWAY_CONFIG_BY_SERVER = "query_gateway_config_by_server";

    /**
     * 修改主机信息
     */
    public static final String UPDATE_GATEWAY_INFO = "update_gateway_info";

    /**
     * 修改主机信息从服务器
     */
    public static final String UPDATE_GATEWAY_INFO_BY_SERVER = "update_gateway_info_by_server";

    /**
     * 修改主机信息
     */
    public static final String UPDATE_GATEWAY_CONFIG = "update_gateway_config";

    /**
     * 修改主机信息从服务器
     */
    public static final String UPDATE_GATEWAY_CONFIG_BY_SERVER = "update_gateway_config_by_server";

    /**
     * 查询待加入设备fdf查询主机信息.
     */
    public static final String QUERY_FREE_DEVICE = "query_waiting_insert_device";

    /**
     * 从主机查询绑定用户信息.
     */
    public static final String QUERY_BIND_USER_FROM_GATEWAY = "query_gateway_bind_user";

    /**
     * 向主机查询报警设置信息.
     */
    public static final String QUERY_ALARM_INFO = "query_alarm_info";

    //TODO query from server.

    /**
     * 从服务器查询设备状态.
     */
    public static final String QUERY_DEVICE_STATE_FROM_SERVER = "query_device_status_by_server";

    /**
     * 从服务器查询设备信息.
     */
    public static final String QUERY_DEVICE_INFO_FROM_SERVER = "query_device_info_by_server";

    /**
     * 从服务器查询设备数据记录.
     */
    public static final String QUERY_DEVICE_DATA_FROM_SERVER = "query_device_data_record_by_server";

    /**
     * 从服务器查询设备操作记录.
     */
    public static final String QUERY_DEVICE_OPERATE_FROM_SERVER = "query_device_operate_record_by_server";

    /**
     * 从服务器查询场景信息.
     */
    public static final String QUERY_SCENE_INFO_FROM_SERVER = "query_scene_info_by_server";


    /**
     * 从服务器查询联动信息.
     */
    public static final String QUERY_LINKAGE_INFO_FROM_SERVER = "query_linkage_info_by_server";

    /**
     * 从服务器查询房间信息.
     */
    public static final String QUERY_ROOM_INFO_FROM_SERVER = "query_room_info_by_server";

    /**
     * 向服务器查询主机绑定用户列表.
     */
    public static final String QUERY_BIND_USER_FROM_SERVER = "query_gateway_bind_user_by_server";

    /**
     * 从服务器查询报警设置信息.
     */
    public static final String QUERY_ALARM_INFO_BY_SERVER = "query_alarm_info_by_server";

    /**
     * 用户信息查询.
     */
    public static final String QUERY_USER_INFO = "query_user_info";

    /**
     * 绑定主机列表查询.
     */
    public static final String QUERY_GATEWAY_LIST = "query_bind_gateway";

    //TODO Node相关.

    /**
     * 添加 ZB 节点.
     */
    public static final String NODE_INSERT = "insert_node";

    /**
     * 删除 ZB 节点.
     */
    public static final String NODE_DELETE = "delete_node";

    /**
     * 查询 ZB 节点信息.
     */
    public static final String NODE_QUERY = "query_node";

    /**
     * 绑定设备和节点关系.
     */
    public static final String BIND_DEVICE_ON_NODE = "bind_device_on_node";

    /**
     * 绑定设备和节点关系.
     */
    public static final String QUERY_GATEWAY_ONLINE_STATE = "query_gateway_online_info";

    /**
     * 设备绑定关系
     */
    public static final String INSERT_DEVICE_BIND = "insert_device_bind";

    public static final String INSERT_DEVICE_BIND_BY_SERVER = "insert_device_bind_by_server";

    /**
     * 取消设备绑定关系
     */
    public static final String DELETE_DEVICE_BIND = "delete_device_bind";

    public static final String DELETE_DEVICE_BIND_BY_SERVER = "delete_device_bind_by_server";

    /**
     * 查询设备绑定关系信息 
     */
    public static final String QUERY_DEVICE_BIND = "query_device_bind_info";

    public static final String QUERY_DEVICE_BIND_BY_SERVER = "query_device_bind_info_by_server";

    /**
     * 查询血压计历史信息
     */
    public static final String QUERY_BLOOD_INFO = "query_blood_info";

    public static final String QUERY_BLOOD_INFO_BY_SERVER = "query_blood_info_by_server";

    /**
     * 血压计、血糖仪、体温枪设备历史数据查询
     */
    public static final String QUERY_DEVICE_DATA_RECORD = "query_device_data_record";

    public static final String QUERY_DEVICE_DATA_RECORD_BY_SERVER = "query_device_data_record_by_server";

    public static final String QUERY_DEVICE_DATA_RECORD_TO_SERVER = "query_device_data_record_to_server";

    /**
     * 修改历史数据
     */
    public static final String UPDATE_DEVICE_DATA_RECORD = "update_device_data_record";
    public static final String UPDATE_DEVICE_DATA_RECORD_BY_SERVER = "update_device_data_record_by_server";

    /**
     * 删除历史数据
     */
    public static final String DELETE_DEVICE_DATA_RECORD = "delete_device_data_record";
    public static final String DELETE_DEVICE_DATA_RECORD_BY_SERVER = "delete_device_data_record_by_server";
    public static final String DELETE_DEVICE_DATA_RECORD_TO_SERVER = "delete_device_data_record_to_server";

    /**
     * 查询亲友关系
     */
    public static final String QUERY_RELATIVE_INFO = "query_relative_info";
    public static final String QUERY_RELATIVE_INFO_BY_SERVER = "query_relative_info_by_server";

    /**
     * 添加亲友关系
     */
    public static final String INSERT_RELATIVE_INFO = "insert_relative_info";
    public static final String INSERT_RELATIVE_INFO_BY_SERVER = "insert_relative_info_by_server";

    /**
     * 修改亲友关系
     */
    public static final String UPDATE_RELATIVE_INFO = "update_relative_info";
    public static final String UPDATE_RELATIVE_INFO_BY_SERVER = "update_relative_info_by_server";

    /**
     * 删除亲友关系
     */
    public static final String DELETE_RELATIVE_INFO = "delete_relative_info";
    public static final String DELETE_RELATIVE_INFO_BY_SERVER = "delete_relative_info_by_server";

    /**
     * 操作亲友关系
     */
    public static final String OPERATION_MEDICALDEV_RELATIVE_INFO = "operation_MedicalDev_relative_info";
    public static final String OPERATION_MEDICALDEV_RELATIVE_INFO_BY_SERVER = "operation_MedicalDev_relative_info_by_server";

    /**
     * 查询设备是否可用
     * query_MedicalDev_status /query_MedicalDev_status_by_server
     */
    public static final String QUERY_MEDICALDEV_STATUS = "query_MedicalDev_status";
    public static final String QUERY_MEDICALDEV_STATUS_BY_SERVER = "query_MedicalDev_status_by_server";
}
