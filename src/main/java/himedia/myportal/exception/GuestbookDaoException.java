package himedia.myportal.exception;


import himedia.myportal.repositories.vo.GuestbookVo;

public class GuestbookDaoException 
	extends RuntimeException {
	private GuestbookVo guestbookVo = null;
	
	public GuestbookDaoException() {
		
	}
	
	public GuestbookDaoException(String message) {
		super(message);
	}
	
	public GuestbookDaoException(String message,
			GuestbookVo vo) {
		super(message);
		this.guestbookVo = vo;
	}

	public GuestbookVo getGuestbookVo() {
		return guestbookVo;
	}

	public void setGuestbookVo(GuestbookVo guestbookVo) {
		this.guestbookVo = guestbookVo;
	}
}