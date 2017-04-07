require 'rails_helper'

RSpec.describe User, type: :model do

  # Association test
  # ensure Todo model has a 1:m relationship with the Item model
  it { should have_many(:items).dependent(:destroy) }

  # Validation tests
  # ensure columns are present before saving
  it { should validate_presence_of(:name) }
  it { should validate_presence_of(:sex) }
  it { should validate_presence_of(:address) }
  it { should validate_presence_of(:age) }
  it { should validate_presence_of(:city) }
  it { should validate_presence_of(:email)}
  it { should validate_presence_of(:password) }
end
