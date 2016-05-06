package com.lifeisquest.controller.v1;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.domain.Notice;
import com.lifeisquest.service.NoticeService;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@RestController
@RequestMapping("api/v1/notice")
public class NoticeController {

  @Autowired
  NoticeService noticeService;

  @Get("")
  public ResponseObj getLatestNotice() {
    Notice latestNotice = noticeService.getLatestNotice();
    return new ResponseObj(MessageCode.SUCCESS, latestNotice);
  }
}
