package com.example.base.myProcessor.registry;

/**
 * todo 动态注册和删除processor
 */
public interface Registry {

    void registry(RegistryContext context);

    void remove(RegistryContext context);
}
