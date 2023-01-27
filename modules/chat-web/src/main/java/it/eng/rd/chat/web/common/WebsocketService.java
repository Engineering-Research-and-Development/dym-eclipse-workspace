package it.eng.rd.chat.web.common;

import com.liferay.portal.kernel.model.User;

public interface WebsocketService {
  void sendChatMessage(User paramUser1, User paramUser2, Long paramLong);
  
  void typingMessage(User paramUser1, User paramUser2);
  
  void sendRequest(User paramUser1, User paramUser2);
  
  void requestAction(User paramUser1, User paramUser2, boolean paramBoolean);
  
  void clearStorage(Long paramLong);
}
