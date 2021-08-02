package sample;

/**
 * FX(Foreign Exchange)
 *
 * @author Zexho
 * @date 2021/7/30 6:58 下午
 */
public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;

    /**
     * 通过构造函数传入参数
     *
     * @param listener
     * @param persist
     */
    public FXNewsProvider(IFXNewsListener listener, IFXNewsPersister persist) {
        this.newsListener = listener;
        this.newPersistener = persist;
    }

    /**
     * 获取和抓取news
     */
    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();
        if (newsIds == null || newsIds.length == 0) {
            return;
        }

        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newPersistener.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }

    }

}