package com.shenchao.messageConvert;

import com.shenchao.bean.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by shenchao on 2017/2/21.
 */
public class MyHttpMessageConvert extends AbstractHttpMessageConverter<User> {
    public MyHttpMessageConvert() {
        super(new MediaType("application", "x-shenchao", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] split = temp.split("-");
        return new User(new Integer(split[0]), split[1]);
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + user.getId() + "-" + user.getName();
        httpOutputMessage.getBody().write(out.getBytes("UTF-8"));
    }
}
