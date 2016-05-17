package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Get("")
  public Principal user(Principal principal) {
    return principal;
  }
}
