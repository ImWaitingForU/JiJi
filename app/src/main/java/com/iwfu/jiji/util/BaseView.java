package com.iwfu.jiji.util;

/**
 * Created by Iwfu on 2016/8/10.
 *
 * View共同接口
 */
public interface BaseView<T> {

    /**
     * 向fragment传入presenter
     * @param presenter
     */
    void setPresenter(T presenter);

}
