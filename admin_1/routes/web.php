<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome_admin');
})->name('welcome');
Route::post('/logout','Admin\LoginController@logout')->name('logout');
Route::get('/home','HomeController@index')->name('home')->middleware('check_admin');
Route::get('/home/categories','CategoryController@index')->name('list_category')->middleware('check_admin');
Route::resource('/home/categories','Admin\CategoriesController',['as'=>'home'])->middleware('check_admin');
Route::resource('/home/vungmien','Admin\VungmienController',['as'=>'home'])->middleware('check_admin');
Route::resource('/home/baiviet','Admin\BaivietController',['as'=>'home'])->middleware('check_admin');
Route::resource('/home/nguoidung','Admin\NguoidungController',['as'=>'home'])->middleware('check_admin');
Route::get('/authlogin','Admin\LoginController@getAuthLogin')->name('getlogin');
Route::post('/authlogin','Admin\LoginController@postAuthLogin')->name('postlogin');
Route::get('/search/Categories','Admin\CategoriesController@search');
Route::get('/search/Baiviet','Admin\BaivietController@search');
Route::get('/search/Nguoidung','Admin\NguoidungController@search');
Route::get('/search/Vungmien','Admin\VungmienController@search');