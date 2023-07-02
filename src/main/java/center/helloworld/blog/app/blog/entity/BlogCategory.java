package center.helloworld.blog.app.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogCategory {

    /**
     * 组件
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 关联的文章数量
     */
    @TableField(exist = false)
    private Integer relaticeArticleCount;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;

}
