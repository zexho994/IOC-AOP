package sample;

/**
 * grab news
 *
 * @author Zexho
 * @date 2021/7/30 7:02 下午
 */
public interface IFXNewsListener {

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);

    /**
     * 获取新闻
     *
     * @return
     */
    String[] getAvailableNewsIds();
}
