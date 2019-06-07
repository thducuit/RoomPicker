package k300.com.response.handler;

import k300.com.response.ResponseResult;
import org.springframework.http.HttpStatus;

public final class ResponseResultHandler {

	public static ResponseResult handleSuccess(HttpStatus httpStatus, Object data) {

		ResponseResult result = new ResponseResult();
		result.setCode(httpStatus.value());
		result.setMessage(httpStatus.getReasonPhrase());
		result.setMessageCode(httpStatus.getReasonPhrase());
		result.setData(data);

		return result;
	}

	public static ResponseResult handleSuccess(HttpStatus httpStatus) {

		ResponseResult result = new ResponseResult();
		result.setCode(httpStatus.value());
		result.setMessage(httpStatus.getReasonPhrase());
		result.setMessageCode(httpStatus.getReasonPhrase());

		return result;
	}

	public static ResponseResult handleSuccess(HttpStatus httpStatus, String message) {

		ResponseResult result = new ResponseResult();
		result.setCode(httpStatus.value());
		result.setMessage(message);
		result.setMessageCode(httpStatus.getReasonPhrase());

		return result;
	}

	public static ResponseResult handleError(HttpStatus httpStatus, Exception ex, Object data) {

		ResponseResult result = new ResponseResult();
		result.setCode(httpStatus.value());
		result.setMessage(ex.getMessage());
		result.setMessageCode(httpStatus.getReasonPhrase());
		result.setSuccess(false);
		result.setData(data);

		return result;
	}

	public static ResponseResult handleError(HttpStatus httpStatus, Exception ex) {

		ResponseResult result = new ResponseResult();
		result.setCode(httpStatus.value());
		result.setMessage(ex.getMessage());
		result.setMessageCode(httpStatus.getReasonPhrase());
		result.setSuccess(false);

		return result;
	}


	private ResponseResultHandler() {
	}
}
