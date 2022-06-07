package com.sys.credit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sys.credit.entity.CreditCardEntity;
import com.sys.credit.mapper.CreditCardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

/**
 * @author Bandit
 * @createTime 2022/6/6 16:41
 */
@SpringBootTest
public class Tests {

    @Autowired
    CreditCardMapper mapper;

    @Test
    void contextLoads() {
        mapper.insert(new CreditCardEntity(null, 2, "测试", 1, 0));
        List<CreditCardEntity> cardList = mapper.selectList(new QueryWrapper<>());
        cardList.forEach(System.out::println);
    }

    @Test
    void test() {
        FastAutoGenerator.create("jdbc:oracle:thin:@39.106.87.37:1521:XE", "bandit", "123456")
                .globalConfig(builder -> {
                    builder.author("bandit") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.sys") // 设置父包名
                            .moduleName("credit") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E://generator")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("CREDIT_CARD"); // 设置需要生成的表名
                            //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }


}
