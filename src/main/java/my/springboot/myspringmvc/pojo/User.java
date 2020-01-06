package my.springboot.myspringmvc.pojo;

import lombok.Getter;
import lombok.Setter;
import my.springboot.myspringmvc.enumeration.SexEnum;
import org.apache.ibatis.type.Alias;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Alias(value = "user")
public class User {
    @NonNull
    private Long id;
    private String userName;
    private String note;
    //性别枚举，这里需要使用typeHandler进行转换
    private SexEnum sex;
}