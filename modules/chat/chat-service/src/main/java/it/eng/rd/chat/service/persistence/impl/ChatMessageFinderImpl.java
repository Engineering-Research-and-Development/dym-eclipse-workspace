package it.eng.rd.chat.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.model.impl.UserImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.service.persistence.ChatMessageFinder;

//public class ChatMessageFinderImpl extends ChatMessageFinderBaseImpl implements ChatMessageFinder {
@Component(service = ChatMessageFinder.class)
public class ChatMessageFinderImpl extends ChatMessageFinderBaseImpl implements ChatMessageFinder {
  public List<User> getUserByRecentChat(long userId) {
    Session session = null;
    SessionFactory sessionFactory = null;
    try {
      sessionFactory = (SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");
      session = sessionFactory.openSession();
      String sql = CustomSQLUtil.get(getClass(), FIND_USER_BY_RECENT_CHAT);
      SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);
      sqlQuery.setCacheable(false);
      sqlQuery.addEntity("User_", UserImpl.class);
      QueryPos pos = QueryPos.getInstance((Query)sqlQuery);
      pos.add(userId);
      pos.add(userId);
      return sqlQuery.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sessionFactory.closeSession(session);
      closeSession(session);
    } 
    return new ArrayList<>();
  }
  
  public static final String FIND_USER_BY_RECENT_CHAT =
		  ChatMessageFinder.class.getName() +
		        ".getUserByRecentChat";
}

