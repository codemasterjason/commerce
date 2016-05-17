package com.lifeisquest.service;

import com.lifeisquest.domain.Notice;
import com.lifeisquest.repository.NoticeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

  @Autowired
  NoticeRepository noticeRepository;

  @Override
  public Notice getLatestNotice() {
    return noticeRepository.findLastByOrderById();
  }
}
