package com.yantz.boot.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yantz.boot.system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * mybatis-plus 字段自动填充
 *
 * @author haoxr
 * @since 2022/10/14
 */
@Slf4j
@RequiredArgsConstructor
public class MyMetaObjectHandler implements MetaObjectHandler {

    private final UserService userService;

    /**
     * 新增填充创建时间
     *
     * @param metaObject 元数据
     */
    @Override
    public void insertFill(MetaObject metaObject) {
//        UserInfoVO currentUserInfo = userService.getCurrentUserInfo();
//        log.info("start insert fill currentUserInfo:{}", currentUserInfo);
//        this.strictInsertFill(metaObject, "createBy",Long.class, currentUserInfo.getUserId());
//        this.strictUpdateFill(metaObject, "updateBy",Long.class, currentUserInfo.getUserId());
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

    /**
     * 更新填充更新时间
     *
     * @param metaObject 元数据
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        UserInfoVO currentUserInfo = userService.getCurrentUserInfo();
//        this.strictUpdateFill(metaObject, "updateBy",Long.class, currentUserInfo.getUserId());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

}
