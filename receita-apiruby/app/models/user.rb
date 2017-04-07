class User < ApplicationRecord
  # Include default devise modules.
  devise :database_authenticatable, :registerable,
          :recoverable, :rememberable, :trackable, :validatable,
           :omniauthable
  include DeviseTokenAuth::Concerns::User

	has_many :items , dependent: :destroy

	validates_presence_of :name,:age,:sex,:address,:city,:email,:password
end
