package com.example.base.myProcessor.registry;

import com.example.base.myProcessor.context.RegistryContext;

/**
 * todo 后续可动态注册和删除processor（这个目前考虑不够全面）
 */
public interface Registry {

    void registry(RegistryContext context);

    void remove(RegistryContext context);
}
