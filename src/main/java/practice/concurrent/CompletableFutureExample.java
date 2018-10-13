package practice.concurrent;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.junit.Test;

public class CompletableFutureExample {


  private final static Random random = new Random();
  @Test
  public void test1() throws ExecutionException, InterruptedException {
    CompletableFuture completableFuture=new CompletableFuture();
    CompletableFuture<Integer> test1 = CompletableFuture.completedFuture("test1")
        .thenApply(new RenderImage());
    test1.get();
  }




  private static class RenderImage implements Callable<Integer>, Function<String, Integer> {

    @Override
    public Integer call() throws Exception {
      int i = random.nextInt(1000);
      TimeUnit.MILLISECONDS.sleep(i);
      return i;
    }

    @Override
    public Integer apply(String s) {
      System.out.println("function:"+s);
      return Integer.parseInt(s);
    }
  }
}

