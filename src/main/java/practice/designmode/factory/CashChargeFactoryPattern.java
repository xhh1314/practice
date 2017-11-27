package practice.designmode.factory;

public class CashChargeFactoryPattern {

}

/**
 * 接受单价和数量，计算总价
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
class CalculateTotalPrice{
	
	public double calculatePrice(int num,double price){
		double totalPrice=num*price;
		return 	CashFactory.getCash().returnCash(totalPrice);
		
	}

	public double discountPrice(int num,double price){
		double totalPrice=num*price;
		//手工new 需要的算法对象，这种策略比较方便
		return 	new CashContext(new DiscountCash(0.8)).returnCash(totalPrice);
		
	}
	
}


/**
 * 策略模式实现，把算法抽象
 * 前台调用的时候手动new 出对应的对象
 * 如果前台有下拉选项选择使用不同的策略，那么这里可以case switch 的方式后台做判定，再用工厂方式生成对象
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
class CashContext{
	private final Cash cashTragedy;
	CashContext(Cash cashTragedy){
		this.cashTragedy=cashTragedy;
	}
	public double returnCash(double cash){
		
		return cashTragedy.returnCash(cash);
	}
	
}


/**
 * 现金工厂，使用这个类返回相应的类
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
class CashFactory{
	public static Cash getCash(){
		return new NormalCash(); 
	}
	
}

/**
 * 现金抽象类，不同的促销模式，使用不用的类实现这个接口
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
interface Cash{
	
	double returnCash(double cash);
}

/**
 * 正常收费类，不打折
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
class NormalCash implements Cash{

	@Override
	public double returnCash(double cash) {
		// TODO Auto-generated method stub
		return cash;
	}
	
}

/**
 * 打折类，直接打几折
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
class DiscountCash implements Cash{
	private final double discount;
	DiscountCash(double discount){
		this.discount=discount;
	}
	@Override
	public double returnCash(double cash) {
		// TODO Auto-generated method stub
		return cash*discount;
	}
	
	
}


/**
 * 现金返利类，满多少，减多少
 * @author lh
 * @date 2017年10月13日
 * @version 
 */
class RebateCash implements Cash{
	
	private final double limit;
	private final double decrease;
	RebateCash(double limit,double decrease){
		this.limit=limit;
		this.decrease=decrease;
	}

	@Override
	public double returnCash(double cash) {
		// TODO Auto-generated method stub
		return cash>=limit?cash-decrease:cash;
	}
	
	
	
}
