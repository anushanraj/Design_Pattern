package com.impact.problem5.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.impact.problem5.model.Assets;
import com.impact.problem5.util.HibernateUtil;

public class AssetsDao {

	public void getAssetById(int assetId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Assets assets = session.get(Assets.class, assetId);
		System.out.println(assets);
		session.close();
	}

	public void getMaxPriceAsset() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Assets> query = session.createQuery("select a from Assets a order by a.assetPrice desc");
		Assets asset = query.list().get(0);
		System.out.println("Max price asset is " + asset);
		session.close();
	}

	public void getAvgAssetPrice() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.getNamedQuery("findAvgPriceByLocation");
		List<Object[]> list = query.getResultList();
		for (Object[] obj : list)
			System.out.println(obj[1] + ":" + obj[0]);
		session.close();

	}

}
