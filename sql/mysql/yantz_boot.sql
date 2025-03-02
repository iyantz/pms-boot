-- ----------------------------
-- 1. 创建数据库
-- ----------------------------
CREATE DATABASE IF NOT EXISTS yantz_boot CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;

-- ----------------------------
-- 2. 创建表 && 数据初始化
-- ----------------------------
use yantz_boot;

SET NAMES utf8mb4; -- # 设置字符集
SET FOREIGN_KEY_CHECKS = 0;  -- # 关闭外键检查，加快导入速度

-- ----------------------------
-- Table structure for gen_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '表名',
  `module_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模块名',
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '包名',
  `business_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务名',
  `entity_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实体类名',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者',
  `parent_menu_id` bigint NULL DEFAULT NULL COMMENT '上级菜单ID，对应sys_menu的id ',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tablename`(`table_name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码生成基础配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_config
-- ----------------------------

-- ----------------------------
-- Table structure for gen_field_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_field_config`;
CREATE TABLE `gen_field_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `config_id` bigint NOT NULL COMMENT '关联的配置ID',
  `column_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `column_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `column_length` int NULL DEFAULT NULL,
  `field_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字段名称',
  `field_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字段类型',
  `field_sort` int NULL DEFAULT NULL COMMENT '字段排序',
  `field_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字段描述',
  `max_length` int NULL DEFAULT NULL,
  `is_required` tinyint(1) NULL DEFAULT NULL COMMENT '是否必填',
  `is_show_in_list` tinyint(1) NULL DEFAULT 0 COMMENT '是否在列表显示',
  `is_show_in_form` tinyint(1) NULL DEFAULT 0 COMMENT '是否在表单显示',
  `is_show_in_query` tinyint(1) NULL DEFAULT 0 COMMENT '是否在查询条件显示',
  `query_type` tinyint NULL DEFAULT NULL COMMENT '查询方式',
  `form_type` tinyint NULL DEFAULT NULL COMMENT '表单类型',
  `dict_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典类型',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `config_id`(`config_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码生成字段配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_field_config
-- ----------------------------

-- ----------------------------
-- Table structure for pms_attachment
-- ----------------------------
DROP TABLE IF EXISTS `pms_attachment`;
CREATE TABLE `pms_attachment`  (
  `attachment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '附件ID',
  `business_id` bigint NULL DEFAULT NULL COMMENT '业务ID',
  `file_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名称',
  `file_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件路径',
  `file_size` bigint NOT NULL COMMENT '文件大小',
  `file_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件类型',
  `upload_time` datetime NOT NULL COMMENT '上传时间',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`attachment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '附件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for pms_defect
-- ----------------------------
DROP TABLE IF EXISTS `pms_defect`;
CREATE TABLE `pms_defect`  (
  `defect_id` bigint NOT NULL AUTO_INCREMENT COMMENT '缺陷ID',
  `project_id` bigint NOT NULL COMMENT '项目ID',
  `defect_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缺陷名称',
  `proposer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缺陷提出人',
  `fixer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缺陷修复人',
  `propose_time` datetime NULL DEFAULT NULL COMMENT '缺陷提出时间',
  `fix_time` datetime NULL DEFAULT NULL COMMENT '缺陷修复时间',
  `fix_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缺陷修复状态',
  `priority` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缺陷优先级',
  `defect_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缺陷类型',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`defect_id`) USING BTREE,
  INDEX `idx_project_id`(`project_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '缺陷信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_defect
-- ----------------------------

-- ----------------------------
-- Table structure for pms_project
-- ----------------------------
DROP TABLE IF EXISTS `pms_project`;
CREATE TABLE `pms_project`  (
  `project_id` bigint NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `project_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '项目名称',
  `project_short_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目简称',
  `party_a` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合同甲方',
  `party_b` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合同乙方',
  `project_period` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目周期',
  `project_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '项目金额',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简介',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`project_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_project
-- ----------------------------

-------------------------------
-- Table structure for pms_project_plan
-- ----------------------------
DROP TABLE IF EXISTS `pms_project_plan`;
CREATE TABLE `pms_project_plan`  (
  `plan_id` bigint NOT NULL AUTO_INCREMENT COMMENT '计划ID',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `plan_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计划名称',
  `plan_time` datetime NULL DEFAULT NULL COMMENT '计划完成时间',
  `plan_actual_time` datetime NULL DEFAULT NULL COMMENT '实际完成时间',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目计划表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for pms_release
-- ----------------------------
DROP TABLE IF EXISTS `pms_release`;
CREATE TABLE `pms_release`  (
  `release_id` bigint NOT NULL AUTO_INCREMENT COMMENT '发布ID',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `plan_version` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计划版本',
  `release_module` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发布模块',
  `release_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`release_id`) USING BTREE,
  INDEX `idx_project_id`(`project_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '发布信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_release
-- ----------------------------

-- ----------------------------
-- Table structure for pms_release_content
-- ----------------------------
DROP TABLE IF EXISTS `pms_release_content`;
CREATE TABLE `pms_release_content`  (
  `content_id` bigint NOT NULL AUTO_INCREMENT COMMENT '内容ID',
  `release_id` bigint NULL DEFAULT NULL COMMENT '发布ID',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `file_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件路径',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`content_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '发布内容表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_release_content
-- ----------------------------

-- ----------------------------
-- Table structure for pms_release_plan
-- ----------------------------
DROP TABLE IF EXISTS `pms_release_plan`;
CREATE TABLE `pms_release_plan`  (
  `plan_id` bigint NOT NULL AUTO_INCREMENT COMMENT '计划ID',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `plan_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计划名称',
  `plan_version` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计划版本',
  `plan_time` datetime NULL DEFAULT NULL COMMENT '计划时间',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '发布计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_release_plan
-- ----------------------------

-- ----------------------------
-- Table structure for pms_requirement
-- ----------------------------
DROP TABLE IF EXISTS `pms_requirement`;
CREATE TABLE `pms_requirement`  (
  `requirement_id` bigint NOT NULL AUTO_INCREMENT COMMENT '需求ID',
  `project_id` bigint NOT NULL COMMENT '项目ID',
  `requirement_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '需求名称',
  `proposer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '需求提出人',
  `propose_time` datetime NULL DEFAULT NULL COMMENT '需求提出时间',
  `expect_finish_time` datetime NULL DEFAULT NULL COMMENT '预计完成时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '完成状态',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`requirement_id`) USING BTREE,
  INDEX `idx_project_id`(`project_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '需求信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_requirement
-- ----------------------------

-- ----------------------------
-- Table structure for pms_task
-- ----------------------------
DROP TABLE IF EXISTS `pms_task`;
CREATE TABLE `pms_task`  (
  `task_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `requirement_id` bigint NULL DEFAULT NULL COMMENT '需求ID',
  `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务名称',
  `priority` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '优先级',
  `expect_start_time` datetime NULL DEFAULT NULL COMMENT '预计开始时间',
  `expect_finish_time` datetime NULL DEFAULT NULL COMMENT '预计完成时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '完成状态',
  `actual_start_time` datetime NULL DEFAULT NULL COMMENT '实际开始时间',
  `actual_finish_time` datetime NULL DEFAULT NULL COMMENT '实际完成时间',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`task_id`) USING BTREE,
  INDEX `idx_requirement_id`(`requirement_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_task
-- ----------------------------

-- ----------------------------
-- Table structure for pms_work_order
-- ----------------------------
DROP TABLE IF EXISTS `pms_work_order`;
CREATE TABLE `pms_work_order`  (
  `work_order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '工单ID',
  `project_id` bigint NULL DEFAULT NULL COMMENT '项目ID',
  `requirement_id` bigint NULL DEFAULT NULL COMMENT '需求ID',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工单标题',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '工单描述',
  `handler_id` bigint NULL DEFAULT NULL COMMENT '指定处理人ID',
  `handler_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
  `priority` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '优先级（1低 2中 3高）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '工单状态（0待处理 1处理中 2已处理）',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`work_order_id`) USING BTREE,
  INDEX `idx_project_id`(`project_id` ASC) USING BTREE,
  INDEX `idx_requirement_id`(`requirement_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '工单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_work_order
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `config_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配置名称',
  `config_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配置key',
  `config_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配置值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除 1-已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '系统限流QPS', 'IP_QPS_THRESHOLD_LIMIT', '10', '单个IP请求的最大每秒查询数（QPS）阈值Key', '2025-03-01 08:51:15', 1, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门编号',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父节点id',
  `tree_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '父节点id路径',
  `sort` smallint NULL DEFAULT 0 COMMENT '显示顺序',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态(1-正常 0-禁用)',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标识(1-已删除 0-未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code` ASC) USING BTREE COMMENT '部门编号唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '同舟科技研发部', 'DEV001', 0, '0', 1, 1, 1, NULL, 1, '2025-03-01 17:25:18', 0);
INSERT INTO `sys_dept` VALUES (2, '研发部门', 'RD001', 1, '0,1', 1, 1, 2, NULL, 2, '2025-03-01 08:51:14', 0);
INSERT INTO `sys_dept` VALUES (3, '测试部门', 'QA001', 1, '0,1', 1, 1, 2, NULL, 2, '2025-03-01 08:51:14', 0);
INSERT INTO `sys_dept` VALUES (4, '管理部门', 'MG001', 1, '0,1', 1, 1, 2, '2025-03-01 18:03:15', NULL, '2025-03-01 18:03:15', 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `dict_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型编码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型名称',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '启用状态(0:禁用;1:启用)',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '是否删除(1-删除，0-未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_dict_code`(`dict_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, 'gender', '性别', 1, NULL, '2025-03-01 08:51:14', 1, '2025-03-01 08:51:14', 1, 0);
INSERT INTO `sys_dict` VALUES (2, 'notice_type', '通知类型', 1, NULL, '2025-03-01 08:51:14', 1, '2025-03-01 19:12:37', 1, 1);
INSERT INTO `sys_dict` VALUES (3, 'notice_level', '通知级别', 1, NULL, '2025-03-01 08:51:14', 1, '2025-03-01 19:12:35', 1, 1);
INSERT INTO `sys_dict` VALUES (4, 'DICT_ACTIVE', '生效状态', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 19:29:22', 1, 0);
INSERT INTO `sys_dict` VALUES (5, 'DICT_MENU_LEVEL', '菜单等级', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 11:24:40', 1, 0);
INSERT INTO `sys_dict` VALUES (6, 'DICT_COMP_STATUS', '完成状态', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 11:24:40', 1, 0);
INSERT INTO `sys_dict` VALUES (7, 'DICT_PUBLISH_TYPE', '项目发布附件类型', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 11:24:40', 1, 0);
INSERT INTO `sys_dict` VALUES (8, 'DICT_MODEL', '所属业务模块', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 11:24:40', 1, 0);
INSERT INTO `sys_dict` VALUES (9, 'DICT_DOC_STATUS', '工单状态', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 11:24:40', 1, 0);
INSERT INTO `sys_dict` VALUES (10, 'DICT_BUG_TYPE', '缺陷类型', 1, NULL, '2025-03-01 11:24:40', 1, '2025-03-01 11:24:40', 1, 0);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联字典编码，与sys_dict表中的dict_code对应',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典项值',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典项标签',
  `tag_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签类型，用于前端样式展示（如success、warning等）',
  `status` tinyint NULL DEFAULT 0 COMMENT '状态（1-正常，0-禁用）',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 'gender', '1', '男', 'primary', 1, 1, NULL, '2025-03-01 08:51:14', 1, '2025-03-01 08:51:14', 1);
INSERT INTO `sys_dict_data` VALUES (2, 'gender', '2', '女', 'danger', 1, 2, NULL, '2025-03-01 08:51:14', 1, '2025-03-01 08:51:14', 1);
INSERT INTO `sys_dict_data` VALUES (3, 'gender', '0', '保密', 'info', 1, 3, NULL, '2025-03-01 08:51:14', 1, '2025-03-01 08:51:14', 1);
INSERT INTO `sys_dict_data` VALUES (13, 'DICT_ACTIVE', '0', '未生效', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (14, 'DICT_ACTIVE', '1', '已生效', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (15, 'DICT_MENU_LEVEL', '2', '目录', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (16, 'DICT_MENU_LEVEL', '1', '菜单', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (17, 'DICT_MENU_LEVEL', '3', '外链', 'info', 1, 2, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (18, 'DICT_MENU_LEVEL', '4', '按钮', 'info', 1, 3, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (19, 'DICT_COMP_STATUS', '0', '未开始', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (20, 'DICT_COMP_STATUS', '1', '进行中', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (21, 'DICT_COMP_STATUS', '2', '已完成', 'info', 1, 2, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (22, 'DICT_COMP_STATUS', '3', '已延期', 'info', 1, 3, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (23, 'DICT_COMP_STATUS', '4', '已取消', 'info', 1, 4, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (24, 'DICT_PUBLISH_TYPE', '1', 'SQL 本', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (25, 'DICT_PUBLISH_TYPE', '2', '配置文件', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (26, 'DICT_PUBLISH_TYPE', '3', '服务器脚本', 'info', 1, 2, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (27, 'DICT_MODEL', '1', '需求管理', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (28, 'DICT_MODEL', '2', '任务管理', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (29, 'DICT_MODEL', '3', '缺陷管理', 'info', 1, 2, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (30, 'DICT_MODEL', '4', '项目信息', 'info', 1, 3, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (31, 'DICT_DOC_STATUS', '0', '未开始', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (32, 'DICT_DOC_STATUS', '1', '进行中', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (33, 'DICT_DOC_STATUS', '2', '已完成', 'info', 1, 2, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (34, 'DICT_DOC_STATUS', '3', '已延期', 'info', 1, 3, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (35, 'DICT_BUG_TYPE', '1', '代码缺陷', 'info', 1, 0, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (36, 'DICT_BUG_TYPE', '2', '设计缺陷', 'info', 1, 1, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (37, 'DICT_BUG_TYPE', '3', '不是缺陷', 'info', 1, 2, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);
INSERT INTO `sys_dict_data` VALUES (38, 'DICT_BUG_TYPE', '4', '发布缺陷', 'info', 1, 3, NULL, '2025-03-01 11:26:31', 1, '2025-03-01 11:26:31', 1);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `module` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志模块',
  `request_method` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求方式',
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数(批量请求参数可能会超过text)',
  `response_content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '返回参数',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志内容',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求路径',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '方法名',
  `ip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `province` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
  `execution_time` bigint NULL DEFAULT NULL COMMENT '执行时间(ms)',
  `browser` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '浏览器',
  `browser_version` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '浏览器版本',
  `os` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '终端系统',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标识(1-已删除 0-未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 191 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', NULL, '2025-03-01 17:24:03', 0);
INSERT INTO `sys_log` VALUES (2, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:24:20', 0);
INSERT INTO `sys_log` VALUES (3, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:24:20', 0);
INSERT INTO `sys_log` VALUES (4, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:24:28', 0);
INSERT INTO `sys_log` VALUES (5, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:24:32', 0);
INSERT INTO `sys_log` VALUES (6, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:24:34', 0);
INSERT INTO `sys_log` VALUES (7, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:24:37', 0);
INSERT INTO `sys_log` VALUES (8, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'MSEdge', '131.0.0.0', 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:25:18', 0);
INSERT INTO `sys_log` VALUES (9, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:41:56', 0);
INSERT INTO `sys_log` VALUES (10, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:41:56', 0);
INSERT INTO `sys_log` VALUES (11, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:53:44', 0);
INSERT INTO `sys_log` VALUES (12, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:54:10', 0);
INSERT INTO `sys_log` VALUES (13, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:54:14', 0);
INSERT INTO `sys_log` VALUES (14, 'DICT', 'GET', '{\"dictCode\":\"gender\",\"pageNum\":1,\"pageSize\":10}', NULL, '字典数据分页列表', '/api/v1/dict-data/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:54:18', 0);
INSERT INTO `sys_log` VALUES (15, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:55:00', 0);
INSERT INTO `sys_log` VALUES (16, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:55:17', 0);
INSERT INTO `sys_log` VALUES (17, 'USER', 'GET', '{}', NULL, '用户表单数据', '/api/v1/users/3/form', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:56:07', 0);
INSERT INTO `sys_log` VALUES (18, 'USER', 'GET', '{\"deptId\":1,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:56:21', 0);
INSERT INTO `sys_log` VALUES (19, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:56:26', 0);
INSERT INTO `sys_log` VALUES (20, 'USER', 'GET', '{\"deptId\":3,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:56:27', 0);
INSERT INTO `sys_log` VALUES (21, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:56:29', 0);
INSERT INTO `sys_log` VALUES (22, 'USER', 'GET', '{\"deptId\":1,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:56:29', 0);
INSERT INTO `sys_log` VALUES (23, 'USER', 'GET', '{\"deptId\":1,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:26', 0);
INSERT INTO `sys_log` VALUES (24, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:27', 0);
INSERT INTO `sys_log` VALUES (25, 'USER', 'GET', '{\"deptId\":3,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:27', 0);
INSERT INTO `sys_log` VALUES (26, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:28', 0);
INSERT INTO `sys_log` VALUES (27, 'USER', 'GET', '{\"deptId\":1,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:28', 0);
INSERT INTO `sys_log` VALUES (28, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:36', 0);
INSERT INTO `sys_log` VALUES (29, 'USER', 'GET', '{\"deptId\":1,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:36', 0);
INSERT INTO `sys_log` VALUES (30, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:37', 0);
INSERT INTO `sys_log` VALUES (31, 'USER', 'GET', '{\"deptId\":3,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:37', 0);
INSERT INTO `sys_log` VALUES (32, 'USER', 'GET', '{\"deptId\":2,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:38', 0);
INSERT INTO `sys_log` VALUES (33, 'USER', 'GET', '{\"deptId\":1,\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:57:38', 0);
INSERT INTO `sys_log` VALUES (34, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:58:09', 0);
INSERT INTO `sys_log` VALUES (35, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:58:11', 0);
INSERT INTO `sys_log` VALUES (36, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:58:11', 0);
INSERT INTO `sys_log` VALUES (37, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 17:58:45', 0);
INSERT INTO `sys_log` VALUES (38, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:00:02', 0);
INSERT INTO `sys_log` VALUES (39, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:00:08', 0);
INSERT INTO `sys_log` VALUES (40, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:00:46', 0);
INSERT INTO `sys_log` VALUES (41, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:02:44', 0);
INSERT INTO `sys_log` VALUES (42, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:03:15', 0);
INSERT INTO `sys_log` VALUES (43, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:03:49', 0);
INSERT INTO `sys_log` VALUES (44, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:03:59', 0);
INSERT INTO `sys_log` VALUES (45, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:03', 0);
INSERT INTO `sys_log` VALUES (46, 'USER', 'GET', '{}', NULL, '用户表单数据', '/api/v1/users/3/form', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:14', 0);
INSERT INTO `sys_log` VALUES (47, 'USER', 'PUT', '{} {\"id\":3,\"username\":\"test\",\"nickname\":\"测试小用户\",\"mobile\":\"18812345679\",\"gender\":1,\"avatar\":\"https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif\",\"email\":\"yantztech@163.com\",\"status\":1,\"deptId\":3,\"roleIds\":[3]}', NULL, '修改用户', '/api/v1/users/3', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:30', 0);
INSERT INTO `sys_log` VALUES (48, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:30', 0);
INSERT INTO `sys_log` VALUES (49, 'USER', 'DELETE', '{ids=3}', NULL, '删除用户', '/api/v1/users/3', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:38', 0);
INSERT INTO `sys_log` VALUES (50, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:38', 0);
INSERT INTO `sys_log` VALUES (51, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:44', 0);
INSERT INTO `sys_log` VALUES (52, 'USER', 'DELETE', '{ids=1}', NULL, '删除用户', '/api/v1/users/1', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:47', 0);
INSERT INTO `sys_log` VALUES (53, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:48', 0);
INSERT INTO `sys_log` VALUES (54, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:49', 0);
INSERT INTO `sys_log` VALUES (55, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:04:49', 0);
INSERT INTO `sys_log` VALUES (56, 'USER', 'POST', '{\"username\":\"pm\",\"nickname\":\"项目经理\",\"mobile\":\"13100002222\",\"gender\":1,\"avatar\":\"https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif\",\"email\":\"111@163.com\",\"status\":1,\"deptId\":4,\"roleIds\":[13]}', NULL, '新增用户', '/api/v1/users', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:05:35', 0);
INSERT INTO `sys_log` VALUES (57, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:05:35', 0);
INSERT INTO `sys_log` VALUES (58, 'USER', 'POST', '{\"username\":\"dm\",\"nickname\":\"开发经理\",\"mobile\":\"13211112222\",\"gender\":1,\"avatar\":\"https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif\",\"email\":\"2222@163.com\",\"status\":1,\"deptId\":2,\"roleIds\":[14]}', NULL, '新增用户', '/api/v1/users', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:06:11', 0);
INSERT INTO `sys_log` VALUES (59, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:06:11', 0);
INSERT INTO `sys_log` VALUES (60, 'USER', 'POST', '{\"username\":\"dv\",\"nickname\":\"开发人员\",\"mobile\":\"17500001234\",\"gender\":1,\"avatar\":\"https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif\",\"email\":\"123@163.com\",\"status\":1,\"deptId\":2,\"roleIds\":[15]}', NULL, '新增用户', '/api/v1/users', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:06:54', 0);
INSERT INTO `sys_log` VALUES (61, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:06:54', 0);
INSERT INTO `sys_log` VALUES (62, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:07:00', 0);
INSERT INTO `sys_log` VALUES (63, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:10:08', 0);
INSERT INTO `sys_log` VALUES (64, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:10:57', 0);
INSERT INTO `sys_log` VALUES (65, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:11:04', 0);
INSERT INTO `sys_log` VALUES (66, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:11:23', 0);
INSERT INTO `sys_log` VALUES (67, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:11:40', 0);
INSERT INTO `sys_log` VALUES (68, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:13:06', 0);
INSERT INTO `sys_log` VALUES (69, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:13:27', 0);
INSERT INTO `sys_log` VALUES (70, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:13:29', 0);
INSERT INTO `sys_log` VALUES (71, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:13:45', 0);
INSERT INTO `sys_log` VALUES (72, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:14:32', 0);
INSERT INTO `sys_log` VALUES (73, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:15:54', 0);
INSERT INTO `sys_log` VALUES (74, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:16:02', 0);
INSERT INTO `sys_log` VALUES (75, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:16:43', 0);
INSERT INTO `sys_log` VALUES (76, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:17:44', 0);
INSERT INTO `sys_log` VALUES (77, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:17:52', 0);
INSERT INTO `sys_log` VALUES (78, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:18:01', 0);
INSERT INTO `sys_log` VALUES (79, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:18:56', 0);
INSERT INTO `sys_log` VALUES (80, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:19:07', 0);
INSERT INTO `sys_log` VALUES (81, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:19:26', 0);
INSERT INTO `sys_log` VALUES (82, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:19:39', 0);
INSERT INTO `sys_log` VALUES (83, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:19:51', 0);
INSERT INTO `sys_log` VALUES (84, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:20:00', 0);
INSERT INTO `sys_log` VALUES (85, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:20:24', 0);
INSERT INTO `sys_log` VALUES (86, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:20:41', 0);
INSERT INTO `sys_log` VALUES (87, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:21:00', 0);
INSERT INTO `sys_log` VALUES (88, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:21:07', 0);
INSERT INTO `sys_log` VALUES (89, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:21:55', 0);
INSERT INTO `sys_log` VALUES (90, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:01', 0);
INSERT INTO `sys_log` VALUES (91, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:24', 0);
INSERT INTO `sys_log` VALUES (92, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:37', 0);
INSERT INTO `sys_log` VALUES (93, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:38', 0);
INSERT INTO `sys_log` VALUES (94, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:40', 0);
INSERT INTO `sys_log` VALUES (95, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:40', 0);
INSERT INTO `sys_log` VALUES (96, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:22:54', 0);
INSERT INTO `sys_log` VALUES (97, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:10', 0);
INSERT INTO `sys_log` VALUES (98, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:14', 0);
INSERT INTO `sys_log` VALUES (99, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:25', 0);
INSERT INTO `sys_log` VALUES (100, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:34', 0);
INSERT INTO `sys_log` VALUES (101, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:44', 0);
INSERT INTO `sys_log` VALUES (102, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:46', 0);
INSERT INTO `sys_log` VALUES (103, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:53', 0);
INSERT INTO `sys_log` VALUES (104, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:23:56', 0);
INSERT INTO `sys_log` VALUES (105, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:24:01', 0);
INSERT INTO `sys_log` VALUES (106, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:24:26', 0);
INSERT INTO `sys_log` VALUES (107, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:36:19', 0);
INSERT INTO `sys_log` VALUES (108, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:36:22', 0);
INSERT INTO `sys_log` VALUES (109, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:36:34', 0);
INSERT INTO `sys_log` VALUES (110, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:36:41', 0);
INSERT INTO `sys_log` VALUES (111, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', NULL, '2025-03-01 18:36:49', 0);
INSERT INTO `sys_log` VALUES (112, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:36:56', 0);
INSERT INTO `sys_log` VALUES (113, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:36:56', 0);
INSERT INTO `sys_log` VALUES (114, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:37:08', 0);
INSERT INTO `sys_log` VALUES (115, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:37:11', 0);
INSERT INTO `sys_log` VALUES (116, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', NULL, '2025-03-01 18:37:16', 0);
INSERT INTO `sys_log` VALUES (117, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:37:25', 0);
INSERT INTO `sys_log` VALUES (118, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:37:25', 0);
INSERT INTO `sys_log` VALUES (119, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:37:26', 0);
INSERT INTO `sys_log` VALUES (120, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:39:43', 0);
INSERT INTO `sys_log` VALUES (121, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:39:54', 0);
INSERT INTO `sys_log` VALUES (122, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:42:05', 0);
INSERT INTO `sys_log` VALUES (123, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:42:23', 0);
INSERT INTO `sys_log` VALUES (124, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:42:37', 0);
INSERT INTO `sys_log` VALUES (125, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:43:51', 0);
INSERT INTO `sys_log` VALUES (126, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:44:59', 0);
INSERT INTO `sys_log` VALUES (127, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:45:22', 0);
INSERT INTO `sys_log` VALUES (128, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:45:36', 0);
INSERT INTO `sys_log` VALUES (129, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:45:58', 0);
INSERT INTO `sys_log` VALUES (130, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:46:34', 0);
INSERT INTO `sys_log` VALUES (131, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:46:51', 0);
INSERT INTO `sys_log` VALUES (132, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:47:43', 0);
INSERT INTO `sys_log` VALUES (133, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:48:21', 0);
INSERT INTO `sys_log` VALUES (134, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:48:39', 0);
INSERT INTO `sys_log` VALUES (135, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:48:45', 0);
INSERT INTO `sys_log` VALUES (136, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:49:17', 0);
INSERT INTO `sys_log` VALUES (137, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:50:28', 0);
INSERT INTO `sys_log` VALUES (138, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:53:51', 0);
INSERT INTO `sys_log` VALUES (139, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:54:08', 0);
INSERT INTO `sys_log` VALUES (140, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:54:14', 0);
INSERT INTO `sys_log` VALUES (141, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:54:21', 0);
INSERT INTO `sys_log` VALUES (142, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:54:45', 0);
INSERT INTO `sys_log` VALUES (143, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:56:31', 0);
INSERT INTO `sys_log` VALUES (144, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 18:56:52', 0);
INSERT INTO `sys_log` VALUES (145, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:01:46', 0);
INSERT INTO `sys_log` VALUES (146, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:02:49', 0);
INSERT INTO `sys_log` VALUES (147, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:04:06', 0);
INSERT INTO `sys_log` VALUES (148, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:04:22', 0);
INSERT INTO `sys_log` VALUES (149, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:04:29', 0);
INSERT INTO `sys_log` VALUES (150, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:05:02', 0);
INSERT INTO `sys_log` VALUES (151, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:06:17', 0);
INSERT INTO `sys_log` VALUES (152, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:06:25', 0);
INSERT INTO `sys_log` VALUES (153, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:06:47', 0);
INSERT INTO `sys_log` VALUES (154, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:07:45', 0);
INSERT INTO `sys_log` VALUES (155, 'LOGIN', 'DELETE', '{}', NULL, '注销', '/api/v1/auth/logout', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', NULL, '2025-03-01 19:07:49', 0);
INSERT INTO `sys_log` VALUES (156, 'LOGIN', 'POST', 'admin 123456', NULL, '登录', '/api/v1/auth/login', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:07:58', 0);
INSERT INTO `sys_log` VALUES (157, 'USER', 'GET', '', NULL, '获取当前登录用户信息', '/api/v1/users/me', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:07:58', 0);
INSERT INTO `sys_log` VALUES (158, 'ROLE', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '角色分页列表', '/api/v1/roles/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:07:59', 0);
INSERT INTO `sys_log` VALUES (159, 'USER', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '用户分页列表', '/api/v1/users/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:08:04', 0);
INSERT INTO `sys_log` VALUES (160, 'MENU', 'GET', '{}', NULL, '菜单列表', '/api/v1/menus', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:10:01', 0);
INSERT INTO `sys_log` VALUES (161, 'DEPT', 'GET', '{}', NULL, '部门列表', '/api/v1/dept', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:10:08', 0);
INSERT INTO `sys_log` VALUES (162, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:11:51', 0);
INSERT INTO `sys_log` VALUES (163, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:12:35', 0);
INSERT INTO `sys_log` VALUES (164, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:12:37', 0);
INSERT INTO `sys_log` VALUES (165, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:28:21', 0);
INSERT INTO `sys_log` VALUES (166, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:28:24', 0);
INSERT INTO `sys_log` VALUES (167, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":20}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:28:26', 0);
INSERT INTO `sys_log` VALUES (168, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":20}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:28:28', 0);
INSERT INTO `sys_log` VALUES (169, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":20}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:09', 0);
INSERT INTO `sys_log` VALUES (170, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":20}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:11', 0);
INSERT INTO `sys_log` VALUES (171, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":20}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:11', 0);
INSERT INTO `sys_log` VALUES (172, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":20}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:11', 0);
INSERT INTO `sys_log` VALUES (173, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:15', 0);
INSERT INTO `sys_log` VALUES (174, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:15', 0);
INSERT INTO `sys_log` VALUES (175, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:22', 0);
INSERT INTO `sys_log` VALUES (176, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:29:59', 0);
INSERT INTO `sys_log` VALUES (177, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:00', 0);
INSERT INTO `sys_log` VALUES (178, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:00', 0);
INSERT INTO `sys_log` VALUES (179, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:00', 0);
INSERT INTO `sys_log` VALUES (180, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:00', 0);
INSERT INTO `sys_log` VALUES (181, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:00', 0);
INSERT INTO `sys_log` VALUES (182, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:00', 0);
INSERT INTO `sys_log` VALUES (183, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:33', 0);
INSERT INTO `sys_log` VALUES (184, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:34', 0);
INSERT INTO `sys_log` VALUES (185, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典分页列表', '/api/v1/dict/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:57', 0);
INSERT INTO `sys_log` VALUES (186, 'DICT', 'GET', '{\"dictCode\":\"DICT_MENU_LEVEL\",\"pageNum\":1,\"pageSize\":10}', NULL, '字典数据分页列表', '/api/v1/dict-data/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:30:59', 0);
INSERT INTO `sys_log` VALUES (187, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典数据分页列表', '/api/v1/dict-data/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:31:01', 0);
INSERT INTO `sys_log` VALUES (188, 'DICT', 'GET', '{\"dictCode\":\"DICT_COMP_STATUS\",\"pageNum\":1,\"pageSize\":10}', NULL, '字典数据分页列表', '/api/v1/dict-data/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:31:10', 0);
INSERT INTO `sys_log` VALUES (189, 'DICT', 'GET', '{\"pageNum\":1,\"pageSize\":10}', NULL, '字典数据分页列表', '/api/v1/dict-data/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:31:14', 0);
INSERT INTO `sys_log` VALUES (190, 'DICT', 'GET', '{\"dictCode\":\"DICT_COMP_STATUS\",\"pageNum\":1,\"pageSize\":10}', NULL, '字典数据分页列表', '/api/v1/dict-data/page', NULL, '192.168.1.6', '0', '内网IP', 0, 'Quark', NULL, 'Windows 10 or Windows Server 2016', 2, '2025-03-01 19:31:50', 0);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint NOT NULL COMMENT '父菜单ID',
  `tree_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父节点ID路径',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `type` tinyint NOT NULL COMMENT '菜单类型（1-菜单 2-目录 3-外链 4-按钮）',
  `route_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由名称（Vue Router 中用于命名路由）',
  `route_path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由路径（Vue Router 中定义的 URL 路径）',
  `component` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径（组件页面完整路径，相对于 src/views/，缺省后缀 .vue）',
  `perm` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '【按钮】权限标识',
  `always_show` tinyint NULL DEFAULT 0 COMMENT '【目录】只有一个子路由是否始终显示（1-是 0-否）',
  `keep_alive` tinyint NULL DEFAULT 0 COMMENT '【菜单】是否开启页面缓存（1-是 0-否）',
  `visible` tinyint(1) NULL DEFAULT 1 COMMENT '显示状态（1-显示 0-隐藏）',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `redirect` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '跳转路径',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 157 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '0', '系统管理', 2, '', '/system', 'Layout', NULL, 1, NULL, 1, 1, 'system', '/system/user', '2025-03-01 08:51:14', '2025-03-01 18:13:06', NULL);
INSERT INTO `sys_menu` VALUES (2, 1, '0,1', '用户管理', 1, 'User', 'user', 'system/user/index', NULL, NULL, 1, 1, 1, 'el-icon-User', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (3, 1, '0,1', '角色管理', 1, 'Role', 'role', 'system/role/index', NULL, NULL, 1, 1, 2, 'role', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (4, 1, '0,1', '菜单管理', 1, 'SysMenu', 'menu', 'system/menu/index', NULL, NULL, 1, 1, 3, 'menu', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (5, 1, '0,1', '部门管理', 1, 'Dept', 'dept', 'system/dept/index', NULL, NULL, 1, 1, 4, 'tree', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (6, 1, '0,1', '字典管理', 1, 'Dict', 'dict', 'system/dict/index', NULL, NULL, 1, 1, 5, 'dict', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (31, 2, '0,1,2', '用户新增', 4, NULL, '', NULL, 'sys:user:add', NULL, NULL, 1, 1, '', '', '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (32, 2, '0,1,2', '用户编辑', 4, NULL, '', NULL, 'sys:user:edit', NULL, NULL, 1, 2, '', '', '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (33, 2, '0,1,2', '用户删除', 4, NULL, '', NULL, 'sys:user:delete', NULL, NULL, 1, 3, '', '', '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (70, 3, '0,1,3', '角色新增', 4, NULL, '', NULL, 'sys:role:add', NULL, NULL, 1, 2, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (71, 3, '0,1,3', '角色编辑', 4, NULL, '', NULL, 'sys:role:edit', NULL, NULL, 1, 3, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (72, 3, '0,1,3', '角色删除', 4, NULL, '', NULL, 'sys:role:delete', NULL, NULL, 1, 4, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (73, 4, '0,1,4', '菜单新增', 4, NULL, '', NULL, 'sys:menu:add', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (74, 4, '0,1,4', '菜单编辑', 4, NULL, '', NULL, 'sys:menu:edit', NULL, NULL, 1, 3, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (75, 4, '0,1,4', '菜单删除', 4, NULL, '', NULL, 'sys:menu:delete', NULL, NULL, 1, 3, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (76, 5, '0,1,5', '部门新增', 4, NULL, '', NULL, 'sys:dept:add', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (77, 5, '0,1,5', '部门编辑', 4, NULL, '', NULL, 'sys:dept:edit', NULL, NULL, 1, 2, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (78, 5, '0,1,5', '部门删除', 4, NULL, '', NULL, 'sys:dept:delete', NULL, NULL, 1, 3, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (79, 6, '0,1,6', '字典新增', 4, NULL, '', NULL, 'sys:dict:add', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (81, 6, '0,1,6', '字典编辑', 4, NULL, '', NULL, 'sys:dict:edit', NULL, NULL, 1, 2, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (84, 6, '0,1,6', '字典删除', 4, NULL, '', NULL, 'sys:dict:delete', NULL, NULL, 1, 3, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (88, 2, '0,1,2', '重置密码', 4, NULL, '', NULL, 'sys:user:password:reset', NULL, NULL, 1, 4, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (105, 2, '0,1,2', '用户查询', 4, NULL, '', NULL, 'sys:user:query', 0, 0, 1, 0, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (106, 2, '0,1,2', '用户导入', 4, NULL, '', NULL, 'sys:user:import', NULL, NULL, 1, 5, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (107, 2, '0,1,2', '用户导出', 4, NULL, '', NULL, 'sys:user:export', NULL, NULL, 1, 6, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (135, 1, '0,1', '字典数据', 1, 'DictData', 'dict-data', 'system/dict/data', NULL, 0, 1, 0, 6, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (136, 135, '0,1,135', '字典数据新增', 4, NULL, '', NULL, 'sys:dict-data:add', NULL, NULL, 1, 2, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (137, 135, '0,1,135', '字典数据编辑', 4, NULL, '', NULL, 'sys:dict-data:edit', NULL, NULL, 1, 3, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (138, 135, '0,1,135', '字典数据删除', 4, NULL, '', NULL, 'sys:dict-data:delete', NULL, NULL, 1, 4, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (139, 3, '0,1,3', '角色查询', 4, NULL, '', NULL, 'sys:role:query', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (140, 4, '0,1,4', '菜单查询', 4, NULL, '', NULL, 'sys:menu:query', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (141, 5, '0,1,5', '部门查询', 4, NULL, '', NULL, 'sys:dept:query', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (142, 6, '0,1,6', '字典查询', 4, NULL, '', NULL, 'sys:dict:query', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (143, 135, '0,1,135', '字典数据查询', 4, NULL, '', NULL, 'sys:dict-data:query', NULL, NULL, 1, 1, '', NULL, '2025-03-01 08:51:14', '2025-03-01 08:51:14', NULL);
INSERT INTO `sys_menu` VALUES (144, 0, '0', '项目管理', 2, NULL, '/project', 'Layout', NULL, 1, 1, 1, 3, 'menu', '/project/projectlist', '2025-03-01 18:15:54', '2025-03-01 18:15:54', NULL);
INSERT INTO `sys_menu` VALUES (145, 0, '0', '工单管理', 2, NULL, '/orderworker', 'Layout', NULL, 1, 1, 1, 5, 'menu', '/orderworker/devorder', '2025-03-01 18:16:42', '2025-03-01 18:17:51', NULL);
INSERT INTO `sys_menu` VALUES (146, 0, '0', '任务管理', 2, NULL, '/task', 'Layout', NULL, 0, 1, 1, 4, 'collapse', '/task/devtask', '2025-03-01 18:17:44', '2025-03-01 18:17:44', NULL);
INSERT INTO `sys_menu` VALUES (147, 0, '0', '发布管理', 2, NULL, '/publish', 'Layout', NULL, 1, 1, 1, 6, 'menu', '/publish/publishlist', '2025-03-01 18:18:56', '2025-03-01 18:18:56', NULL);
INSERT INTO `sys_menu` VALUES (148, 144, '0,144', '项目列表', 1, 'Project', 'project', 'project/projec/index', NULL, 0, 1, 1, 1, '', NULL, '2025-03-01 18:42:05', '2025-03-01 18:54:08', NULL);
INSERT INTO `sys_menu` VALUES (149, 144, '0,144', '需求管理', 1, 'Requirement', 'requirement', 'project/requirement/index', NULL, 0, 1, 1, 3, '', NULL, '2025-03-01 18:43:51', '2025-03-01 18:54:21', NULL);
INSERT INTO `sys_menu` VALUES (150, 144, '0,144', '项目计划', 1, 'Schedule', 'schedule', 'project/schedule/index', NULL, 0, 1, 1, 2, '', NULL, '2025-03-01 18:48:21', '2025-03-01 18:54:14', NULL);
INSERT INTO `sys_menu` VALUES (151, 146, '0,146', '开发任务', 1, 'Develop', 'develop', 'task/develop/index', NULL, 0, 1, 1, 1, NULL, NULL, '2025-03-01 18:50:28', '2025-03-01 18:50:28', NULL);
INSERT INTO `sys_menu` VALUES (152, 146, '0,146', '缺陷管理', 1, 'Bug', 'bug', 'task/bug/index', NULL, 0, 1, 1, 2, NULL, NULL, '2025-03-01 18:53:51', '2025-03-01 18:53:51', NULL);
INSERT INTO `sys_menu` VALUES (153, 145, '0,145', '工单列表', 1, 'OrderWork', 'order-work', 'orderwork/orderwork/index', NULL, 0, 1, 1, 1, NULL, NULL, '2025-03-01 18:56:30', '2025-03-01 18:56:30', NULL);
INSERT INTO `sys_menu` VALUES (154, 147, '0,147', '发布列表', 1, 'Publish', 'publish', 'publish/publish/index', NULL, 0, 1, 1, 2, NULL, NULL, '2025-03-01 19:01:46', '2025-03-01 19:04:29', NULL);
INSERT INTO `sys_menu` VALUES (155, 147, '0,147', '内容管理', 1, 'PublishContent', 'publish-content', 'publish/publishContent/index', NULL, 0, 1, 1, 3, NULL, NULL, '2025-03-01 19:02:49', '2025-03-01 19:05:02', NULL);
INSERT INTO `sys_menu` VALUES (156, 147, '0,147', '发布计划', 1, 'PublishSchdule', 'publish-schdule', 'publish/publishSchdule/index', NULL, 0, 1, 1, 1, NULL, NULL, '2025-03-01 19:04:06', '2025-03-01 19:04:22', NULL);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '通知标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '通知内容',
  `type` tinyint NOT NULL COMMENT '通知类型（关联字典编码：notice_type）',
  `level` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知等级（字典code：notice_level）',
  `target_type` tinyint NOT NULL COMMENT '目标类型（1: 全体, 2: 指定）',
  `target_user_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '目标人ID集合（多个使用英文逗号,分割）',
  `publisher_id` bigint NULL DEFAULT NULL COMMENT '发布人ID',
  `publish_status` tinyint NULL DEFAULT 0 COMMENT '发布状态（0: 未发布, 1: 已发布, -1: 已撤回）',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `revoke_time` datetime NULL DEFAULT NULL COMMENT '撤回时间',
  `create_by` bigint NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除（0: 未删除, 1: 已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, 'v2.12.0 新增系统日志，访问趋势统计功能。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 1, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 1, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (2, 'v2.13.0 新增菜单搜索。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 1, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 1, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (3, 'v2.14.0 新增个人中心。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (4, 'v2.15.0 登录页面改造。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (5, 'v2.16.0 通知公告、字典翻译组件。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 1, 'L', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (6, '系统将于本周六凌晨 2 点进行维护，预计维护时间为 2 小时。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 2, 'H', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (7, '最近发现一些钓鱼邮件，请大家提高警惕，不要点击陌生链接。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 3, 'L', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (8, '国庆假期从 10 月 1 日至 10 月 7 日放假，共 7 天。', '<p>1. 消息通知</p><p>2. 字典重构</p><p>3. 代码生成</p>', 4, 'L', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (9, '公司将在 10 月 15 日举办新产品发布会，敬请期待。', '公司将在 10 月 15 日举办新产品发布会，敬请期待。', 5, 'H', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);
INSERT INTO `sys_notice` VALUES (10, 'v2.16.1 版本发布。', 'v2.16.1 版本修复了 WebSocket 重复连接导致的后台线程阻塞问题，优化了通知公告。', 1, 'M', 1, '2', 2, 1, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 2, '2025-03-01 08:51:16', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色编码',
  `sort` int NULL DEFAULT NULL COMMENT '显示顺序',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '角色状态(1-正常 0-停用)',
  `data_scope` tinyint NULL DEFAULT NULL COMMENT '数据权限(0-所有数据 1-部门及子部门数据 2-本部门数据3-本人数据)',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人 ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除 1-已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name` ASC) USING BTREE COMMENT '角色名称唯一索引',
  UNIQUE INDEX `uk_code`(`code` ASC) USING BTREE COMMENT '角色编码唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROOT', 1, 1, 0, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 08:51:14', 0);
INSERT INTO `sys_role` VALUES (2, '系统管理员', 'ADMIN', 2, 1, 0, NULL, '2025-03-01 08:51:14', NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (3, '访问游客', 'GUEST', 3, 1, 2, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 18:07:00', 1);
INSERT INTO `sys_role` VALUES (4, '系统管理员1', 'ADMIN1', 4, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:54:59', 1);
INSERT INTO `sys_role` VALUES (5, '系统管理员2', 'ADMIN2', 5, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:54:59', 1);
INSERT INTO `sys_role` VALUES (6, '系统管理员3', 'ADMIN3', 6, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:00', 1);
INSERT INTO `sys_role` VALUES (7, '系统管理员4', 'ADMIN4', 7, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:00', 1);
INSERT INTO `sys_role` VALUES (8, '系统管理员5', 'ADMIN5', 8, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:00', 1);
INSERT INTO `sys_role` VALUES (9, '系统管理员6', 'ADMIN6', 9, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:00', 1);
INSERT INTO `sys_role` VALUES (10, '系统管理员7', 'ADMIN7', 10, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:00', 1);
INSERT INTO `sys_role` VALUES (11, '系统管理员8', 'ADMIN8', 11, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:00', 1);
INSERT INTO `sys_role` VALUES (12, '系统管理员9', 'ADMIN9', 12, 1, 1, NULL, '2025-03-01 08:51:14', NULL, '2025-03-01 17:55:04', 1);
INSERT INTO `sys_role` VALUES (13, '项目经理', 'PROJECTADMIN', 1, 1, 1, NULL, '2025-03-01 17:58:45', NULL, '2025-03-01 18:03:49', 0);
INSERT INTO `sys_role` VALUES (14, '开发经理', 'DP-ADMIN', 1, 1, 2, NULL, '2025-03-01 18:00:02', NULL, '2025-03-01 18:03:58', 0);
INSERT INTO `sys_role` VALUES (15, '开发人员', 'DP-001', 1, 1, 2, NULL, '2025-03-01 18:00:46', NULL, '2025-03-01 18:04:03', 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  UNIQUE INDEX `uk_roleid_menuid`(`role_id` ASC, `menu_id` ASC) USING BTREE COMMENT '角色菜单唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (2, 31);
INSERT INTO `sys_role_menu` VALUES (2, 32);
INSERT INTO `sys_role_menu` VALUES (2, 33);
INSERT INTO `sys_role_menu` VALUES (2, 70);
INSERT INTO `sys_role_menu` VALUES (2, 71);
INSERT INTO `sys_role_menu` VALUES (2, 72);
INSERT INTO `sys_role_menu` VALUES (2, 73);
INSERT INTO `sys_role_menu` VALUES (2, 74);
INSERT INTO `sys_role_menu` VALUES (2, 75);
INSERT INTO `sys_role_menu` VALUES (2, 76);
INSERT INTO `sys_role_menu` VALUES (2, 77);
INSERT INTO `sys_role_menu` VALUES (2, 78);
INSERT INTO `sys_role_menu` VALUES (2, 79);
INSERT INTO `sys_role_menu` VALUES (2, 81);
INSERT INTO `sys_role_menu` VALUES (2, 84);
INSERT INTO `sys_role_menu` VALUES (2, 88);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 135);
INSERT INTO `sys_role_menu` VALUES (2, 136);
INSERT INTO `sys_role_menu` VALUES (2, 137);
INSERT INTO `sys_role_menu` VALUES (2, 138);
INSERT INTO `sys_role_menu` VALUES (2, 139);
INSERT INTO `sys_role_menu` VALUES (2, 140);
INSERT INTO `sys_role_menu` VALUES (2, 141);
INSERT INTO `sys_role_menu` VALUES (2, 142);
INSERT INTO `sys_role_menu` VALUES (2, 143);
INSERT INTO `sys_role_menu` VALUES (2, 144);
INSERT INTO `sys_role_menu` VALUES (2, 145);
INSERT INTO `sys_role_menu` VALUES (2, 146);
INSERT INTO `sys_role_menu` VALUES (2, 147);
INSERT INTO `sys_role_menu` VALUES (2, 148);
INSERT INTO `sys_role_menu` VALUES (2, 149);
INSERT INTO `sys_role_menu` VALUES (2, 150);
INSERT INTO `sys_role_menu` VALUES (2, 151);
INSERT INTO `sys_role_menu` VALUES (2, 152);
INSERT INTO `sys_role_menu` VALUES (2, 153);
INSERT INTO `sys_role_menu` VALUES (2, 154);
INSERT INTO `sys_role_menu` VALUES (2, 155);
INSERT INTO `sys_role_menu` VALUES (2, 156);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(1) NULL DEFAULT 1 COMMENT '性别((1-男 2-女 0-保密)',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `dept_id` int NULL DEFAULT NULL COMMENT '部门ID',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态(1-正常 0-禁用)',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除 1-已删除)',
  `openid` char(28) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信 openid',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_name`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'root', '有来技术', 0, '$2a$10$xVWsNOhHrCxh5UbpCE7/HuJ.PAOKcYAqRxD2CO2nVnJS.IAXkr5aq', NULL, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '18812345677', 1, 'yantztech@163.com', '2025-03-01 08:51:15', NULL, '2025-03-01 18:04:47', NULL, 1, NULL);
INSERT INTO `sys_user` VALUES (2, 'admin', '系统管理员', 1, '$2a$10$xVWsNOhHrCxh5UbpCE7/HuJ.PAOKcYAqRxD2CO2nVnJS.IAXkr5aq', 1, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '18812345678', 1, 'yantztech@163.com', '2025-03-01 08:51:15', NULL, '2025-03-01 08:51:15', NULL, 0, NULL);
INSERT INTO `sys_user` VALUES (3, 'test', '测试小用户', 1, '$2a$10$xVWsNOhHrCxh5UbpCE7/HuJ.PAOKcYAqRxD2CO2nVnJS.IAXkr5aq', 3, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '18812345679', 1, 'yantztech@163.com', '2025-03-01 08:51:15', NULL, '2025-03-01 18:04:38', NULL, 1, NULL);
INSERT INTO `sys_user` VALUES (4, 'pm', '项目经理', 1, '$2a$10$.qFU5QWweiIoBSAKRPyepeEsDS/cDWvjb20mIt0u5DofXEpKkxUzq', 4, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '13100002222', 1, '111@163.com', '2025-03-01 18:05:35', NULL, '2025-03-01 18:05:35', NULL, 0, NULL);
INSERT INTO `sys_user` VALUES (5, 'dm', '开发经理', 1, '$2a$10$uuoVWVIHyzi4qrYGPR4B0Ono0MnN37OCsjZN8ZaZE.TW3kFv2rgBK', 2, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '13211112222', 1, '2222@163.com', '2025-03-01 18:06:11', NULL, '2025-03-01 18:06:11', NULL, 0, NULL);
INSERT INTO `sys_user` VALUES (6, 'dv', '开发人员', 1, '$2a$10$YqLjA.KCNOxkSaHsMqahA.jMvWzmiYkqo/CjsGacG3qNmqfO/hJMy', 2, 'https://foruda.gitee.com/images/1723603502796844527/03cdca2a_716974.gif', '17500001234', 1, '123@163.com', '2025-03-01 18:06:54', NULL, '2025-03-01 18:06:54', NULL, 0, NULL);

-- ----------------------------
-- Table structure for sys_user_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_notice`;
CREATE TABLE `sys_user_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `notice_id` bigint NOT NULL COMMENT '公共通知id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `is_read` bigint NULL DEFAULT 0 COMMENT '读取状态（0: 未读, 1: 已读）',
  `read_time` datetime NULL DEFAULT NULL COMMENT '阅读时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除(0: 未删除, 1: 已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_notice
-- ----------------------------
INSERT INTO `sys_user_notice` VALUES (1, 1, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (2, 2, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (3, 3, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (4, 4, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (5, 5, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (6, 6, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (7, 7, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (8, 8, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (9, 9, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);
INSERT INTO `sys_user_notice` VALUES (10, 10, 2, 1, NULL, '2025-03-01 08:51:16', '2025-03-01 08:51:16', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 3);
INSERT INTO `sys_user_role` VALUES (4, 13);
INSERT INTO `sys_user_role` VALUES (5, 14);
INSERT INTO `sys_user_role` VALUES (6, 15);

SET FOREIGN_KEY_CHECKS = 1;
