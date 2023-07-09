package com.blaquesystems.backend;

import com.blaquesystems.backend.service.MediaUpload;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringBootSecurityJwtApplicationTests {

	@Autowired
	MediaUpload mediaUpload;

	@Test
	public void contextLoads() {
	}

	@Test
	public void uploaudFile() throws IOException {
//		String url = mediaUpload.uploadMedia();
//		System.out.println(url);

	}
}
