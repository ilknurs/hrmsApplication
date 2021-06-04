package software.hrms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import software.hrms.core.utilities.helpers.imageHelper.ImageUploadService;
import software.hrms.core.utilities.helpers.imageHelper.cloudinary.CloudinaryImageManager;

@Configuration
public class AppConfiguration {
	
public Environment environment;
	
    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "djvjbzwie",
                "api_key", "548542998123537",
                "api_secret", "VZmUFHQQV73HFLn46HvmeaqhrpE"));
    }

    @Bean
    public ImageUploadService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }

}
