package center.helloworld.blog.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/11/25 16:10
 * @note 分页返回对象
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {

    /**
     * 总条数
     */
    private Long total = 0L;

    /**
     * 数据
     */
    private List data;
}
