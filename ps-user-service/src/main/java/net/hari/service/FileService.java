package net.hari.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: Hari
 * @Date: 2021/2/23 10:09
 * @Description:
 */
public interface FileService {

    String uploadUserImg(MultipartFile file);

}
