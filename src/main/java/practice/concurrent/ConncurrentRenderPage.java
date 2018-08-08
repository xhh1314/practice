package practice.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 测试异步并行执行
 *
 * @author lh
 * @date 2018/8/8
 * @since
 */
public class ConncurrentRenderPage {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<String> images = new ArrayList<>(16);
        Random random = new Random();
        //初始化下iamges
        for (int i = 0; i < 10000; i++) {
            images.add(random.nextInt(2000) + "");
        }
        //使用CompletionService
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);
        //并行下载图片
        images.forEach(val -> {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return downloadImage(val);
                }
            });
        });
        renderText();
        //并行渲染图片
        for (int i = 0; i < images.size(); i++) {
            Future<String> take = completionService.take();
            renderImage(take.get());
        }
    }


    private static void renderText() {
        System.out.println("渲染页面");
    }

    private static void renderImage(String image) {
        System.out.println("渲染图片：" + image);
    }

    private static String downloadImage(String url) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("下载图片:" + url);
        return "image:" + url;
    }
}
