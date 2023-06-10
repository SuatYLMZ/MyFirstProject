package com.project.schoolmanagment.payload.request.abstracts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder // if a class has a parent class and we want to use builder class,
              // we add super builder on both parent and child class
public class AdminRequest extends BaseUserRequest{


    private boolean builtIn;

}
