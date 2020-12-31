<?php

namespace App\Http\Middleware;
use Auth;
use Closure;

class CheckLogin
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
        if (Auth::guard('nguoidung')->check()&& Auth::guard('nguoidung')->user()->phanquyen==1) {
            return $next($request);
        }
        else{
            return redirect()->route('welcome');
        }
    }
}
