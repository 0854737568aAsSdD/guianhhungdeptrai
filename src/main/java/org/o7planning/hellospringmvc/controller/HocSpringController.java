package org.o7planning.hellospringmvc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HocSpringController {
	@Autowired
	private UserValidator uservalidator;

	@RequestMapping("/dominhtuan")
	public String voidshow() {
		return "baiso6";
	}

	@RequestMapping("/16122000")
	public ModelAndView sayhello(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name = "minhtuan", required = true) String username,
			@RequestHeader(name = "Accept", required = false, defaultValue = "") String content) {
		request.setAttribute("msg", username);
		return new ModelAndView("baiso7");
	}

	@RequestMapping("/hellotuan/{name}")
	public String hello(HttpServletRequest request, @PathVariable(value = "name") String name) {
		request.setAttribute("msg", name);
		return "baiso7";
	}

	@RequestMapping(value = "/them-user", method = RequestMethod.GET)
	public String addUseer(HttpServletRequest request) {
		User user = new User();
		user.setName("spring");
		request.setAttribute("user", user);
		List<String> favo = new ArrayList<>();
		favo.add("nghe nhac ");
		favo.add("xem phim ");
		favo.add("Coding ");
		request.setAttribute("list", favo);
		return "adduser";
	}

	@RequestMapping(value = "/them-user", method = RequestMethod.POST)
	public String addUseer(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		uservalidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			List<String> favo = new ArrayList<>();
			favo.add("nghe nhac ");
			favo.add("xem phim ");
			favo.add("Coding ");
			request.setAttribute("list", favo);
			return "adduser";
		}
		MultipartFile file = user.getAvatar();
		// luu file xuong o cung
		try {
			File newFile = new File("A:\\spring mvc\\" + file.getOriginalFilename());
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		return "viewUser";
	}

	@RequestMapping(value = "/upload-file", method = RequestMethod.GET)
	public String upload(HttpServletRequest request) {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadfile(HttpServletRequest request, @RequestParam(name = "file") List<MultipartFile> files) {
		// luu file xuong o cung
		for (MultipartFile file : files) {
			try {
				File newFile = new File("A:\\spring mvc\\" + file.getOriginalFilename());
				FileOutputStream fileOutputStream;
				fileOutputStream = new FileOutputStream(newFile);
				fileOutputStream.write(file.getBytes());
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("files", files);
		return "viewFile";
	}

	@RequestMapping(value = "/dowload-file", method = RequestMethod.GET)
	public void dowload(HttpServletRequest request, HttpServletResponse response) {
		String dataDirectory = "A:\\spring mvc\\";
		Path file = Paths.get(dataDirectory, "N303_BANDEXUATDUAN.docx");
		if (Files.exists(file)) {
			response.setContentType("application/msword");
			response.addHeader("Content-Disposition", "attachment: filename = anh.jpg");
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
