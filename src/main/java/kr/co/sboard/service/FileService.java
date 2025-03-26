package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {


    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    public void uploadFile(ArticleDTO articleDTO) {

        // 파일 업로드 디렉터리 객체 생성
        File fileUploadDir = new File(uploadDir);

        if(!fileUploadDir.exists()){
            // 파일 업로드 디렉터리가 존재하지 않으면 생성
            fileUploadDir.mkdirs();            
        }

        // 파일 업로드 디렉터리 시스템 경로 구하기
        String fileUploadPath = fileUploadDir.getAbsolutePath();
        


    }

    public void downloadFile(){

    }


}
