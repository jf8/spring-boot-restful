-- INSERT INTO showcase_employee(id, email, hire_date, name, phone_number, salary) VALUES (2, 'junfu.chen@outlook.com', '2018-05-10 12:16:50', 'junfu', '68', 100);

INSERT INTO sys_user(id, login, user_name, password_hash, mobile_phone_number, birthday, sex, image_url, activated, lang_key, activation_key, reset_key, created_by, created_date, reset_date, last_modified_by, last_modified_date) VALUES (1, 'system', 'System', '$2a$10$yLvGQB3Zs.UOCuawGX0uNOr.1xyfFvrEI69.COXfnDDHmsvPEDm72', '13800000002', NULL, NULL, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLB13krGdTicguCuuute5OmnbIyIa4EH3QBrRT8yRfPaRWExUYpoDF6SZIOsmUn5WcJ18SkQDNDjSTg/0', b'1', 'zh_CN', NULL, NULL, 'system', '2017-12-16 18:10:09', NULL, 'system', NULL);
INSERT INTO sys_user(id, login, user_name, password_hash, mobile_phone_number, birthday, sex, image_url, activated, lang_key, activation_key, reset_key, created_by, created_date, reset_date, last_modified_by, last_modified_date) VALUES (2, 'anonymoususer', 'Anonymous', '$2a$10$yLvGQB3Zs.UOCuawGX0uNOr.1xyfFvrEI69.COXfnDDHmsvPEDm72', '13800000003', NULL, NULL, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLB13krGdTicguCuuute5OmnbIyIa4EH3QBrRT8yRfPaRWExUYpoDF6SZIOsmUn5WcJ18SkQDNDjSTg/0', b'1', 'zh_CN', NULL, NULL, 'system', '2017-12-16 18:10:09', NULL, 'system', NULL);
INSERT INTO sys_user(id, login, user_name, password_hash, mobile_phone_number, birthday, sex, image_url, activated, lang_key, activation_key, reset_key, created_by, created_date, reset_date, last_modified_by, last_modified_date) VALUES (3, 'admin', 'Administrator', '$2a$10$yLvGQB3Zs.UOCuawGX0uNOr.1xyfFvrEI69.COXfnDDHmsvPEDm72', '13800000000', NULL, NULL, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLB13krGdTicguCuuute5OmnbIyIa4EH3QBrRT8yRfPaRWExUYpoDF6SZIOsmUn5WcJ18SkQDNDjSTg/0', b'1', 'zh_CN', NULL, NULL, 'system', '2017-12-16 18:10:09', NULL, 'system', NULL);
INSERT INTO sys_user(id, login, user_name, password_hash, mobile_phone_number, birthday, sex, image_url, activated, lang_key, activation_key, reset_key, created_by, created_date, reset_date, last_modified_by, last_modified_date) VALUES (4, 'user', 'User', '$2a$10$yLvGQB3Zs.UOCuawGX0uNOr.1xyfFvrEI69.COXfnDDHmsvPEDm72', '13800000001', NULL, NULL, 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLB13krGdTicguCuuute5OmnbIyIa4EH3QBrRT8yRfPaRWExUYpoDF6SZIOsmUn5WcJ18SkQDNDjSTg/0', b'1', 'zh_CN', NULL, NULL, 'system', '2017-12-16 18:10:09', NULL, 'system', NULL);




INSERT INTO sys_role(id, name, description, created_by, created_date, last_modified_by, last_modified_date) VALUES (1, 'ROLE_ADMIN', '管理员', 'sys', now(), NULL, NULL);
INSERT INTO sys_role(id, name, description, created_by, created_date, last_modified_by, last_modified_date) VALUES (2, 'ROLE_USER', '普通用户', 'sys', now(), NULL, NULL);



INSERT INTO sys_resource(id, name, description, url, pid) VALUES (1, 'ROLE_ADMIN', '综合信息看板', '/api/home', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (2, 'app:user', '用户', '/api/app-users', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (3, 'order', '订单管理', '/api/room-orders', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (4, 'data', '主数据管理', '/api/base-data', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (5, 'room', '办公室空间商管理', '/api/room', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (6, 'gift', '礼品劵管理', '/api/gift', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (7, 'recommend', '推荐为管理', '/api/recommend', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (8, 'finance', '财务', '/api/finance', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (9, 'settings', '系统设置', '/api/settings', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (10, 'admin', '系统管理', '/api/admin', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (11, 'password:rest', '修改密码', '/api/home/rest/password/**', 1);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (12, 'app:user:management', '用户管理', '/api/app-users/**', 2);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (13, 'order:pending-payment', '待付款订单', '/api/room-orders/pending-payment/**', 3);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (14, 'order:pending-confirmation', '待确认订单', '/api/room-orders/pending-confirmation/**', 3);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (15, 'order:effective', '入住订单', '/api/room-orders/effective-order/**', 3);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (16, 'order:refund', '用户退款申请', '/api/room-orders/refund-order/**', 3);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (17, 'data:cra', '区域管理', '/api/regions/**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (18, 'data:metro', '地铁站管理', '/api/metro**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (19, 'data:trade-area', '商圈管理', '/api/trade-areas/**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (20, 'data:type', '分类管理', '/api/types/**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (21, 'data:industry', '行业管理', '/api/industries/**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (22, 'data:tag', 'tag库管理', '/api/tags/**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (23, 'room:businesses', '空间商管理', '/api/room-businesses/**', 5);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (24, 'room:room', '空间管理', '/api/rooms/**', 5);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (25, 'gift:gift', '礼品卷管理', '/api/gift-coupons/**', 6);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (26, 'gift:gifth', '礼品卷发放记录', '/api/gift-coupons-histories/**', 6);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (27, 'recommend', '推荐位管理', '/api/recommend**', 7);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (28, 'finance:management', '财务管理', '/api/finances/**', 8);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (29, 'settings:integral-task', '积分任务', '/api/integral-tasks/**', 9);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (30, 'settings:integral-record', '积分记录', '/api/integral-records/**', 9);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (31, 'settings:integral-level', '积分等级设置', '/api/integral-level-settings/**', 9);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (32, 'admin:sys-roles', '角色管理', '/api/sys-roles/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (33, 'admin:users', '操作员管理', '/api/users/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (34, 'admin:sys-resources', '系统资源', '/api/sys-resources/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (35, 'admin:api-doc', 'API文档', '/v2/api-docs/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (36, 'admin:metrics', '系统指标', '/api/management/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (37, 'admin:logs', '日志', '/api/management/logs/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (38, 'admin:configuration', '配置', '/api/management/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (39, 'admin:tracker', '追踪使用者', '/api/topic/tracker/**', 10);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (40, 'gallery', '图库', '/api/gallery', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (41, 'gallery:gallery', '图库管理', '/api/galleries/**', 40);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (42, 'gallery:picture', '图片管理', '/api/pictures/**', 40);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (43, 'video', '视频管理', '／api/video', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (44, 'video:video', '视频列表', '/api/videos/**', 43);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (45, 'video:watermark', '水印管理', '/api/watermarks/**', 43);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (46, 'evaluate', '评价管理', '/api/evaluate', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (47, 'evaluate:tag', '评价标签管理', '/api/evaluation-tags', 46);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (48, 'evaluate:evaluate', '评价管理', '/api/evaluates', 46);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (49, 'evaluate:enhance', '评价增强', '/api/evaluates/enhance', 46);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (50, 'data:city', '城市管理', '/api/cities/**', 4);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (51, 'inventory', '预约管理', '/api/inventory', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (52, 'inventory:lease-cycle', '预约时段管理', '/api/lease-cycles/**', 51);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (53, 'inventory:lease-day', '预约时段库存设置', '/api/lease-days/**', 51);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (54, 'collect', '收集信息', '/api/collect', 0);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (55, 'collect:collect-information', '收集标签信息', '/api/collect-informations/**', 54);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (56, 'settings:key-value', '键值对', '/api/key-values', 9);
INSERT INTO sys_resource(id, name, description, url, pid) VALUES (57, 'inventory:reservation', '预约列表', '/api/reservations/**', 51);




INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (11, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (12, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (13, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (14, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (15, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (16, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (17, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (18, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (19, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (20, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (21, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (22, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (23, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (24, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (25, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (26, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (27, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (28, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (29, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (30, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (31, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (32, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (33, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (34, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (35, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (36, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (37, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (38, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (39, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (41, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (42, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (44, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (45, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (47, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (48, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (49, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (50, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (52, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (53, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (55, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (56, 1);
INSERT INTO sys_role_sys_resources(sys_resources_id, sys_roles_id) VALUES (57, 1);



INSERT INTO sys_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO sys_user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO sys_user_role(user_id, role_id) VALUES (3, 1);
INSERT INTO sys_user_role(user_id, role_id) VALUES (3, 2);
INSERT INTO sys_user_role(user_id, role_id) VALUES (4, 2);