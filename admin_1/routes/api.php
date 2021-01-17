<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
/*
Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});*/

Route::get('categories','Api\CategoriesController@Category');
/*Route::get('categories/{id}','Api\CategoriesController@CategoryById');
Route::post('categories','Api\CategoriesController@CategorySave');
Route::put('categories/{id}','Api\CategoriesController@CategoryUpdate');
/*Route::delete('categories/{id}','Api\CategoriesController@CategoryDelete');
Route::apiResource('categories','Api\Categories');
Route::apiResource('baiviets','Api\BaivietsApi');
Route::apiResource('vungmiens','Api\VungmiensApi');*/



//đăng nhập
Route::apiResource('taikhoan','Api\TaiKhoanController')->only(['store']);
