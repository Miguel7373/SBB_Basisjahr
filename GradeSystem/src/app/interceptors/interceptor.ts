import {HttpRequest, HttpEvent, HttpInterceptorFn, HttpHandlerFn} from '@angular/common/http';
import { Observable } from 'rxjs';

export const AuthInterceptor: HttpInterceptorFn = (
  req: HttpRequest<any>,
  next: HttpHandlerFn
): Observable<HttpEvent<any>> => {

  if (req.method === 'GET' || req.method === 'PUT' || req.method === 'DELETE' ) {
    const authRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${localStorage.getItem('token')}`
      },
    });
    return next(authRequest);
  }
  console.log("hallo")
  return next(req);
};
