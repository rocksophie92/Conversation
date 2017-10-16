package com.example.p3750852.conversation.networking;

import com.example.p3750852.conversation.models.ErrorWrapper;

/**
 * Created by Patrik on 2016. 10. 05..
 */
public interface RequestCallback<T> {

    void responseReceived(ErrorWrapper r, T o);
}
