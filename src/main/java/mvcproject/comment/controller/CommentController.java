package mvcproject.comment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mvcproject.comment.service.CommentService;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

}
