package com.userservice.app.constant;

public interface ExceptionConstant {

	public static final String NO_FAQ = "COMAPI1";

	public static final String NO_TAC = "COMAPI2";

	public static final String NO_IC = "COMAPI3";
	public static final String NO_MSG = "COMAPI4";

	public static final String ATT_SIZE = "COMAPI5";

	public static final String IO_EXC = "COMAPI6";

	public static final String VALIDATE_TOKEN_FAILED = "COMAPI7";

	public static final String SUCCESS_EC = "200";
	public static final String SUCCESS_ED = "SUCCESS";

	public static final String UNKNOWN_ERROR_EC = "UE102";
	public static final String UNKNOWN_ERROR_ED = "Unknown Exception";

	public static final String FILE_ALREADY_EXIST_EC = "FILEUPLOAD101";
	public static final String FILE_ALREADY_EXIST_ED = "File Already Exist";

	public static final String JOB_NOT_FOUND_EC = "JOB102";
	public static final String JOB_NOT_FOUND_ED = "Invalid Job Name";

	public static final String INVALID_RECORD_EC = "IR103";
	public static final String INVALID_RECORD_ED = "Invalid Record";

	public static final String ERROR_WRITING_FILE_EC = "OCR205";
	public static final String ERROR_WRITING_FILE_ED = "Error writing file to Directory ";

	public static final String INVALID_OTP_EC = "SMPP210";
	public static final String INVALID_OTP_ED = "Invalid OTP !";

	public static final String OTP_EXPIRED_EC = "SMPP211";
	public static final String OTP_EXPIRED_ED = "OTP Expired. Resend OTP !";

	public static final String OTP_NOT_SENT_EC = "SMPP212";
	public static final String OTP_NOT_SENT_ED = "OTP not sent !";

	public static final String SESSION_NOT_BINDED_EC = "SMPP213";
	public static final String SESSION_NOT_BINDED_ED = "Unable to bind session";

	public static final String EMAIL_NOT_SENT_EC = "EMAIL212";
	public static final String EMAIL_NOT_SENT_ED = "Email not sent !";

	public static final String EMAIL_NOT_REG_EC = "EMAIL213";
	public static final String EMAIL_NOT_REG_ED = "Email Not Registered";

	public static final String SMPP_BIND_EC = "SMPP214";
	public static final String SMPP_BIND_ED = "Failed to connect and bind to host";

	public static final String MSISDN_REQUIRED_EC = "SMPP215";
	public static final String MSISDN_REQUIRED_ED = "MSISDN required";
	
	public static final String INVALID_MSISDN_EC = "SMPP216";
	public static final String INVALID_MSISDN_ED = "Invalid MSISDN";

	public static final String EMAIL_REQUIRED_EC = "EMAIL216";
	public static final String EMAIL_REQUIRED_ED = "Email required";
	
	public static final String INVALID_EMAIL_EC = "EMAIL217";
	public static final String INVALID_EMAIL_ED = "Invalid email id";

	public static final String VALID_TOKEN_EC = "JWT217";
	public static final String VALID_TOKEN_ED = "Valid Token";

	public static final String INVALID_TOKEN_EC = "JWT218";
	public static final String INVALID_TOKEN_ED = "Invalid Token";

	public static final String TOKEN_EXPIRED_EC = "JWT219";
	public static final String TOKEN_EXPIRED_ED = "Token Expired";

	public static final String TOKEN_GENERATED_EC = "JWT220";
	public static final String TOKEN_GENERATED_ED = "Token Generated Successfully";

	public static final String TOKEN_REFRESHED_EC = "JWT221";
	public static final String TOKEN_REFRESHED_ED = "Token refreshed";

	public static final String FILE_CANNOT_BE_MOVED_EC = "OCR222";
	public static final String FILE_CANNOT_BE_MOVED_ED = "FILE CANNOT BE MOVED";

	public static final String INVALID_URI_EC = "OCR223";
	public static final String INVALID_URI_ED = "INVALID NRC/PASSPORT URI";

	public static final String FILE_UPLOAD_EX_EC = "OCR224";
	public static final String FILE_UPLOAD_EX_ED = "FILE CANNOT BE UPLOADED";
	
	public static final String INVALID_IMAGE_SIDE_EC = "OCR225";
	public static final String INVALID_IMAGE_SIDE_ED = "Invalid image side";

	public static final String INVALID_PDU_PARAMETER_EC = "SMPP225";
	public static final String INVALID_PDU_PARAMETER_ED = "Invalid pdu parameter";

	public static final String RESPONSE_TIMEOUT_EC = "SMPP226";
	public static final String RESPONSE_TIMEOUT_ED = "Response timeout";

	public static final String RECEIVED_INVALID_RESPONSE_EC = "SMPP227";
	public static final String RECEIVED_INVALID_RESPONSE_ED = "Received invalid response";

	public static final String RECEIVED_NEGATIVE_RESPONSE_EC = "SMPP228";
	public static final String RECEIVED_NEGATIVE_RESPONSE_ED = "Received negative response";

	public static final String IO_ERROR_OCCURED_EC = "SMPP229";
	public static final String IO_ERROR_OCCURED_ED = "IO error occured";

	public static final String REGULAR_ERROR_OCCURED_EC = "SMPP330";
	public static final String REGULAR_ERROR_OCCURED_ED = "Regular error occured";

	public static final String RECORD_NOT_FOUND_EC = "COMMONERROR331";
	public static final String RECORD_NOT_FOUND_ED = "Details Not Found in Database";

	public static final String MAIL_AUTHENTICATION_EXCEPTION_EC = "SMTP332";
	public static final String MAIL_AUTHENTICATION_EXCEPTION_ED = "Mail Authentication Exception";

	public static final String MAIL_SEND_EXCEPTION_EC = "SMTP333";
	public static final String MAIL_SEND_EXCEPTION_ED = "Mail Send Exception";

	public static final String IMAGE_SAVED_IN_DB_EC = "FILEUPLOAD102";
	public static final String IMAGE_SAVED_IN_DB_ED = "Image saved successfully";
	
	public static final String IMAGE_NOT_SAVED_IN_DB_EC = "FILEUPLOAD103";
	public static final String IMAGE_NOT_SAVED_IN_DB_ED = "Image not saved";
	
	public static final String INVALID_IMAGE_FORMAT_EC = "FILEUPLOAD104";
	public static final String INVALID_IMAGE_FORMAT_ED = "Invalid file format. Please upload jpeg/jpg, png, gif, bmp file format only";
	
	public static final String IMAGE_SIZE_EXCEEDS_EC = "FILEUPLOAD105";
	public static final String IMAGE_SIZE_EXCEEDS_ED = "File size should be less than 1 MB";
	
    public static final String EMPTY_FILE_EC = "FILEUPLOAD106";
    public static final String EMPTY_FILE_ED = "Empty file uploaded";
    
    public static final String IMAGE_TYPE_REQUIRED_EC = "FILEUPLOAD107";
    public static final String IMAGE_TYPE_REQUIRED_ED = "Image Type required";
    
    public static final String FILE_NOT_EXIST_EC  = "FILEUPLOAD108";
    public static final String FILE_NOT_EXIST_ED  = "File does not exist";
    
	public static final String IMAGE_DELETED_FROM_DB_EC = "FILEUPLOAD109";
	public static final String IMAGE_DELETED_FROM_DB_ED = "Profile Picture deleted successfully";
	
	public static final String INVALID_FILE_FORMAT_EC = "FILEUPLOAD110";
	public static final String INVALID_FILE_FORMAT_ED = "Invalid file format. Please upload csv file format only";
	
	public static final String FILE_SAVED_IN_DB_EC = "FILEUPLOAD111";
	public static final String FILE_SAVED_IN_DB_ED = "File saved successfully.";
	
    public static final String INVALID_HEADER_EC = "FILEUPLOAD112";
    public static final String INVALID_HEADER_ED = "Invalid header. Please try with correct header.";
    
	public static final String FILE_NOT_SAVED_EC = "FILEUPLOAD113";
	public static final String FILE_NOT_SAVED_ED = "File cannot be saved.";
	
	public static final String NO_CATEGORY_FOUND_EC = "FILEUPLOAD114";
	public static final String NO_CATEGORY_FOUND_ED = "No Category found. Please fist create/upload category";
    
    public static final String INVALID_IMAGE_TYPE_EC = "COMMONERROR332";
    public static final String INVALID_IMAGE_TYPE_ED = "INVALID IMAGE TYPE";
    
    public static final String MAX_OTP_ATTEMPT_REACHED_EC = "SMPP331";
    public static final String MAX_OTP_ATTEMPT_REACHED_ED = "MSISDN Blocked. Max login attempt reached, try after ";
    
    public static final String MSISDN_BLOCKED_FOR_OTP_EC = "SMPP332";
    public static final String MSISDN_BLOCKED_FOR_OTP_ED = "MSISDN is blocked. OTP cannot be sent, try after ";
    
    public static final String MSISDN_BLOCKED_EC = "SMPP333";
    public static final String MSISDN_BLOCKED_ED = "MSISDN is Blocked";
    
    
    public static final String MAX_OTP_ATTEMPT_REACHED_EMAIL_EC = "SMPP334";
    public static final String MAX_OTP_ATTEMPT_REACHED_EMAIL_ED = "Email Id is blocked. Max login attempt reached, try after ";
    
    public static final String EMAIL_BLOCKED_FOR_OTP_EC = "SMPP335";
    public static final String EMAIL_BLOCKED_FOR_OTP_ED = "Email Id is blocked. OTP cannot be sent, try after ";
    
    public static final String EMAIL_BLOCKED_EC = "SMPP336";
    public static final String EMAIL_BLOCKED_ED = "Email Id is Blocked";
    
    public static final String OTP_SENT_EC = "SMPP337";
    public static final String OTP_SENT_ED = "OTP sent successfully to ";
    
    public static final String USER_NOT_REGISTERED_EC = "101";
    public static final String USER_NOT_REGISTERED_ED = "User is not Registered. ";
    
    
    

    
}
