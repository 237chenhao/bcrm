package com.ch.mybcrm.dao.generator;

import org.apache.commons.lang.reflect.FieldUtils;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhao on 2017/6/24.
 */
public class Run {

    public static void main(String[] args) throws Exception {
        String path = Run.class.getClassLoader().getResource("").getPath().replace("target/classes/","");
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(new ClassPathResource("mybatis-generator-config.xml").getInputStream());

        Context context = config.getContext("context");
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(path + javaModelGeneratorConfiguration.getTargetProject());

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = context.getSqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(path + sqlMapGeneratorConfiguration.getTargetProject());

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = context.getJavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(path + javaClientGeneratorConfiguration.getTargetProject());

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("----warning----");
        for (String str : warnings){
            System.out.println(str);
        }

        System.out.println("||||||");
        List<GeneratedJavaFile> generatedJavaFiles = (List<GeneratedJavaFile>) FieldUtils.readField(myBatisGenerator,"generatedJavaFiles",true);
        List<GeneratedXmlFile> generatedXmlFiles = (List<GeneratedXmlFile>) FieldUtils.readField(myBatisGenerator,"generatedXmlFiles",true);
        System.out.println("-----生成的Java文件-----");
        if(generatedJavaFiles != null && !generatedJavaFiles.isEmpty()){
            for(GeneratedJavaFile file : generatedJavaFiles){
                System.out.println(file.getFileName());
            }
        }
        System.out.println("||||||");
        System.out.println("-----生成的xml文件-----");
        if(generatedXmlFiles != null && !generatedXmlFiles.isEmpty()){
            for(GeneratedXmlFile file : generatedXmlFiles){
                System.out.println(file.getFileName());
            }
        }
    }
}
