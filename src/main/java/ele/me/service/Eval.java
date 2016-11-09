package ele.me.service;

import ele.me.dao.DbAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Eval {

    @Autowired
    private DbAccess dbAccess;

    public float eval(List<String> users){
		return (float) (2.0/3*scoreClick(users) + 1.0/3*scoreBuy(users));
	}
	
	private float scoreBuy(List<String> users){
		float result = 0;
		if (users!=null) {
			float a = 0, b = 0;
			for (String userId : users) {
				List<String> realBuy = getRealBuyLog(userId);
				List<String> predBuy = getPredBuyLog(userId);
                if (realBuy.size()>0) {
                    int total = getLogCount(userId);
                    float aucClick = aucPerUser(realBuy, predBuy, total);
                    a += aucClick * Math.log(total + 1);
                    b += Math.log(total + 1);
                }
			}
			result = 100 * a/b;
		}
		return result;
	}
	
	private List<String> getPredBuyLog(String userId) {
        return dbAccess.getPredBuyLog(userId);
	}

	private List<String> getRealBuyLog(String userId) {
		return dbAccess.getRealBuyLog(userId);
	}

	private float scoreClick(List<String> users){
		float result = 0;
		if (users!=null) {
			float a = 0, b = 0;
			for (String userId : users) {
				List<String> realClick = getRealClickLog(userId);
				List<String> predClick = getPredClickLog(userId);
                if (realClick.size()>0){
                    int total = getLogCount(userId);
                    float aucClick = aucPerUser(realClick, predClick, total);
                    a += aucClick*Math.log(total+1);
                    b += Math.log(total+1);
                }
			}
			result = 100 * a/b;
		}
		return result;
	}
	
	private int getLogCount(String userId) {
		return dbAccess.getLogCount(userId);
	}

	private List<String> getPredClickLog(String userId) {
		return dbAccess.getPredClickLog(userId);
	}

	private List<String> getRealClickLog(String userId) {
		return dbAccess.getRealClickLog(userId);
	}

	private float aucPerUser(List<String> real, List<String> pred, int total){
		float result = 0;
		if (real!=null && pred!=null) {
		    float a = (float) (1.0 * getIntersection(real, pred).size()/real.size());
            float b = total-getUnion(real, pred).size();
            if (b == 0) return 1;
            result =  a * b / (total-real.size());
		}
		return result;
	}
	
	private List<String> getIntersection(List<String> a, List<String> b){
		List<String> result = new ArrayList<String>();
		if (a!=null && b!=null) {
			for (int i = 0; i < a.size(); i++) {
				if (b.contains(a.get(i))) {
					result.add(a.get(i));
				}
			}
		}
		return result;
	}
	
	private List<String> getUnion(List<String> a, List<String> b){
		List<String> result = new ArrayList<String>();
		if (a!=null && b!=null) {
			result.addAll(b);
			for (int i = 0; i < a.size(); i++) {
				if (!b.contains(a.get(i))) {
					result.add(a.get(i));
				}
			}
		}
		return result;
	}
}
