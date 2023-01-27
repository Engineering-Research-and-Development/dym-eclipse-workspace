package it.eng.rd.chat.web.message.indexer;

public class ChatMessageObject {
  private Long id;
  
  private String groupId;
  
  private String companyId;
  
  private String fromUser;
  
  private String toUser;
  
  private String sentDate;
  
  private String readDate;
  
  private String message;
  
  private boolean readed;
  
  private boolean deleted;
  
  private String fileName;
  
  private long fileId;
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getGroupId() {
    return this.groupId;
  }
  
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }
  
  public String getCompanyId() {
    return this.companyId;
  }
  
  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }
  
  public String getFromUser() {
    return this.fromUser;
  }
  
  public void setFromUser(String fromUser) {
    this.fromUser = fromUser;
  }
  
  public String getToUser() {
    return this.toUser;
  }
  
  public void setToUser(String toUser) {
    this.toUser = toUser;
  }
  
  public String getSentDate() {
    return this.sentDate;
  }
  
  public void setSentDate(String sentDate) {
    this.sentDate = sentDate;
  }
  
  public String getReadDate() {
    return this.readDate;
  }
  
  public void setReadDate(String readDate) {
    this.readDate = readDate;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public boolean isReaded() {
    return this.readed;
  }
  
  public void setReaded(boolean readed) {
    this.readed = readed;
  }
  
  public boolean isDeleted() {
    return this.deleted;
  }
  
  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
  
  public String getFileName() {
    return this.fileName;
  }
  
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
  
  public long getFileId() {
    return this.fileId;
  }
  
  public void setFileId(long fileId) {
    this.fileId = fileId;
  }
}
