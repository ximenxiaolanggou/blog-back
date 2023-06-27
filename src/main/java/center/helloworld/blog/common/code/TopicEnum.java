package center.helloworld.blog.common.code;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/2/22 12:52
 */
public enum TopicEnum {

    TEMP("temp");

    private String tpoic;

    public String getTopic() {
        return tpoic;
    }


    TopicEnum(String tpoic) {
        this.tpoic = tpoic;
    }
}
