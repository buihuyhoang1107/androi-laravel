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
});

Auth::routes();

Route::get('/home','HomeController@index')->name('home');
Route::get('/home/categories','CategoryController@index')->name('list_category');
Route::resource('/home/categories','Admin\CategoriesController',['as'=>'home']);
Route::resource('/home/vungmien','Admin\VungmienController',['as'=>'home']);
Route::resource('/home/baiviet','Admin\BaivietController',['as'=>'home']);
