package kodlama.io.bootcampProject;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.bootcampProject.core.utilities.exceptions.BusinessException;
import kodlama.io.bootcampProject.core.utilities.results.ErrorDataResult;

@SpringBootApplication
@RestControllerAdvice  //tüm restcontrollerini trycatch in içine koy demek
public class BootcampProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampProjectApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@ExceptionHandler
	@ResponseStatus (code =HttpStatus.BAD_REQUEST)          //burası catch kısmı //bad request kullanıcıdan kaynaklı hatalara denir.
	public ErrorDataResult<Object>handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errorDataResult =new ErrorDataResult<Object>(validationErrors,"VALIDATION.EXCEPTION");
		return errorDataResult;
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST) // burada da onu döndür
	public ErrorDataResult<Object>handleBusinessExceptions(BusinessException businessException){
		ErrorDataResult<Object> errorDataResult =new  ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS.EXCEPTİON");
		return errorDataResult;
	}//(burada yaptığımız hataları filtrelemek)
	
	
}

//reflection: o an çalıştırdığın metodun ismini öğrenmek ,çalışan clasla ilgili bilgi almak istiyorsun,çalışma anında classlarla ilgili bilgi
//bilgi toplama yöntemi.

//diyelimki veri tabanı hatası aldın pasword 1234 yanlış vs dedi:::: log ya da sistemde yapılan bütün addleri loglamak gibi
//NORMALDE HATA YAKALAMAK İÇİN TRYCATCH YAKALIYORSUN ya bu kod IOP kontroller metotlarını controllerın içine koyuyor.
//error data result biİm standart dönüş tipimiz,