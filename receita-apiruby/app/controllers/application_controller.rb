class ApplicationController < ActionController::API
  	include DeviseTokenAuth::Concerns::SetUserByToken
	include Response
	include ExceptionHandler
	before_action :configure_permitted_parameters, if: :devise_controller?

	def configure_permitted_parameters
		devise_parameter_sanitizer.permit(:sign_up, keys: [:sex,:name,:city,:address,:age])
	end
end
